package com.BookMyShow.app.usecases;

import com.BookMyShow.app.dtos.CreateUserDTO;
import com.BookMyShow.app.models.Booking;
import com.BookMyShow.app.models.User;
import com.BookMyShow.app.models.services.utils.passwordEncoder.PasswordEncoder;
import com.BookMyShow.app.repositories.inMemory.InMemoryUserRepository;
import com.BookMyShow.app.repositories.interfaces.UserRepository;

/*all the things that user can do is added over here
 **/
public class UserUseCases {

    /*Why Password Encoder has been added here ? : we will not change the password encoder again
    and again so we injected the dependency directly to the constructor */
    PasswordEncoder passwordEncoder;
    UserRepository userRepository;
    UserUseCases(PasswordEncoder passwordEncoder , UserRepository userRepository){
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }
    public boolean checkPasswordValidity(User user , String password) {
        return user.checkPassword(password , passwordEncoder);
    }

    public void changePassword(User user , String newPassword){
        user.setPassword(newPassword , passwordEncoder);
    }

    public User createUser(CreateUserDTO userDetails){
        User user = new User(userDetails.getUsername());
        user.setPassword(userDetails.getPassword(), passwordEncoder);
        userRepository.save(user);
        return  user;

    }

}
