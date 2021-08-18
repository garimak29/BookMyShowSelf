package com.BookMyShow.app.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class Booking extends Exposed {
    private User user;
    private Show show;
    private BookingStatus status;
    List<ShowSeat> seatsBooked;
}
