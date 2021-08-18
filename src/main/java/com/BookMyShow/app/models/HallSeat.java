package com.BookMyShow.app.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
/*Physical seats , no need to expose the ids for this entity*/
@Getter
@Setter
@Builder
public class HallSeat extends Audit {
    private String seatLocation;
    private String seatType;
    private boolean isUnderMaintainace;
    private Hall hall;
}
