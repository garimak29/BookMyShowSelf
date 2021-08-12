package com.BookMyShow.app.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ShowSeat extends Audit {
    private HallSeat hallSeat;
    private Show show;
}
