package com.BookMyShow.app.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Movie extends Audit{
    private String name;
    private Integer durationMinutes;
}
