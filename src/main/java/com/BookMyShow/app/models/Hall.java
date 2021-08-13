package com.BookMyShow.app.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Hall extends Audit{
    private Cinema cinema;
    private String hallNumber;
    private Integer seatCount;
}
