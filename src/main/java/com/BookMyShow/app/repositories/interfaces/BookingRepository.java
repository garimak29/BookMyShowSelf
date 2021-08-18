package com.BookMyShow.app.repositories.interfaces;

import com.BookMyShow.app.models.Booking;
import com.BookMyShow.app.models.User;

public interface BookingRepository extends AbstractRepository{
    QuerySet<Booking> getBookingByUser(User user);
}
