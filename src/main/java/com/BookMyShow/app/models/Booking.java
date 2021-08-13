package com.BookMyShow.app.models;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class Booking extends Audit {
    private User user;
    private Show show;
    List<ShowSeat> seatsBooked;
}
