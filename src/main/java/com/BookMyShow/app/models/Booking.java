package com.BookMyShow.app.models;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Booking extends Audit {
    private User user;
    private Show show;
    List<ShowSeat> seatsBooked;
}
