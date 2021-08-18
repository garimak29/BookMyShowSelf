package com.BookMyShow.app.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/* seats available to the customer*/
@Getter
@Setter
@Builder
public class ShowSeat extends Exposed {
    private HallSeat hallSeat;
    private Show show;
    private boolean occupied;

}
