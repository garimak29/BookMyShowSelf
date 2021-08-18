package com.BookMyShow.app.usecases;


import com.BookMyShow.app.dtos.CreateBookingDTO;
import com.BookMyShow.app.dtos.CreateUserDTO;
import com.BookMyShow.app.dtos.CustomerRegistrationDTO;
import com.BookMyShow.app.dtos.UpdateCustomerDTO;
import com.BookMyShow.app.exceptions.accounts.AccountAlreadyExistsException;
import com.BookMyShow.app.exceptions.seats.SeatsNotAvailableException;
import com.BookMyShow.app.exceptions.shows.ShowNotExceptingBookingException;
import com.BookMyShow.app.exceptions.validations.UsernameExistsException;
import com.BookMyShow.app.models.*;
import com.BookMyShow.app.repositories.interfaces.*;

public class CustomerUseCases {
    private final UserRepository userRepository;
    private final UserUseCases userUseCases;
    private final CustomerRepository customerRepository;
    private final RoleRepository roleRepository;
    private final BookingRepository bookingRepository;
    private final MovieRepository movieRepository;
    private final CinemaRepository cinemaRepository;

    CustomerUseCases(UserRepository userRepository,
                     UserUseCases userUsecases,
                     CustomerRepository customerRepository,
                     RoleRepository roleRepository,
                     BookingRepository bookingRepository, MovieRepository movieRepository, CinemaRepository cinemaRepository){
        this.userRepository = userRepository;
        this.userUseCases = userUsecases;
        this.customerRepository = customerRepository;
        this.roleRepository = roleRepository;
        this.bookingRepository = bookingRepository;
        this.movieRepository = movieRepository;
        this.cinemaRepository = cinemaRepository;
    }
    public Customer registerCustomer(CustomerRegistrationDTO customerDetails){
        //check if the username is unique or not
        if(userRepository.findByUsername(customerDetails.getUsername()).isPresent()){
            throw new UsernameExistsException("This usernmae "+customerDetails.getUsername()+
                    "already exists. Please choose a different username");
        }
        if(userRepository.findByPhone(customerDetails.getPhone()).isPresent()){
            throw new AccountAlreadyExistsException("This phone "+customerDetails.getPhone()+
                    "already exists. Please login with existing account");
        }
        if(userRepository.findByEmail(customerDetails.getEmail()).isPresent()){
            throw new AccountAlreadyExistsException("This email "+customerDetails.getEmail()+
                    "already exists. Please login with existing account");
        }

        //create new user : not a reponsibility of customer useucase , moving the create user to userUsecase
        User user = userUseCases.createUser(new CreateUserDTO(customerDetails.getUsername(),
                customerDetails.getPassword()));

        //assign roles
        Role customerRole = roleRepository.getRoleByName("customer").get();
        user.addRole(customerRole);
        userRepository.save(user);

        // only create a new customer here
        Customer customer = new Customer(user);
        //set fields
        customer.setCity(customerDetails.getCity());
        customer.setEmail(customerDetails.getEmail());
        customer.setFullName(customerDetails.getFullName());
        customer.setPhone(customerDetails.getPhone());


        customerRepository.save(customer);
        return customer;

    }

    public void deleteCustomer(String username){
        User user = userRepository.findByUsername(username).get();
        Customer customer = customerRepository.findByUser(user).get();
        customerRepository.delete(customer);
        userRepository.delete(user);

    }

    public Customer updateCustomer(Customer customer , UpdateCustomerDTO details){
        if(customer.getCity() != details.getCity())
        {
            customer.setCity(details.getCity());
        }
        else if(customer.getPhone() != details.getPhone())
        {
            customer.setPhone(details.getPhone());
        }
        else if(customer.getFullName() != details.getFullName())
        {
            customer.setFullName(details.getFullName());
        }
        else if(customer.getEmail() != details.getEmail())
        {
            customer.setEmail(details.getEmail());
        }
        customerRepository.save(customer);
        return customer;
    }

    public Booking createBooking(Customer customer , CreateBookingDTO details){
        if(!details.getShow().isShowPending()){
            throw new ShowNotExceptingBookingException("Show is house full");
        }
        // accquire some lock to make sure that all the seats are not pre occupied- , concurrency issue will task place
        // checking if the seats are occupied or not
        boolean seatsAvaialble = details.getShowSeats().stream().noneMatch(ShowSeat::isOccupied);

        if(!seatsAvaialble){
            throw new SeatsNotAvailableException("Seats are not available");
        }
        //create a new booking
        Booking booking = new Booking(customer.getUser() , details.getShow() , details.getShowSeats());
        //change all the seats to occupied
        booking.setSeatsBooked(details.getShowSeats().stream().filter(s->s.setOccupied(true)));

        // save the booking
        bookingRepository.save(booking);
        // release the lock


        /*
        Can be written in 2 ways
        s -> s.isOccupied()
        ShowSeats :: isOccupied
        * */
        return booking;
    }

    public void cancelBooking(Booking booking){
        //check if the booking isnt cancelled already
        if(booking.getShow().isCancelled()){
            throw new ShowAlreadyCancelledException("The show has been cancelled");
        }
        if(booking.getStatus().equals(BookingStatus.CANCELLED)){
            throw new BookingAlreadyCancelledException("Booking has been already cancelled");
        }
        //check if the show hasnt taken place already
        if(booking.getShow().isShowPending()){
            //if the payment has been made
            if(booking.getStatus().equals(BookingStatus.PAYMENT_DONE)){
                //bookingRefundService.getRefund(Booking)
                //otpService.sendRefundInitiatedOTP(booking.getCustomer.getPhone())
                //delete booking
                bookingRepository.delete(booking);

            }


        }


    }
    //Queryset because we need lazy querying , as we might want to add filters and pagination
    public QuerySet<Booking> listCustomerBookings(User user){
        return bookingRepository.getBookingByUser(user);


    }

    public QuerySet<Movie> listMovies(Cinema cinema){
        return movieRepository.getMovieByCinema(cinema);

    }

    public QuerySet<Cinema> listCinema(Movie movie){
        return cinemaRepository.getCinemaByMovie(movie);

    }
}
