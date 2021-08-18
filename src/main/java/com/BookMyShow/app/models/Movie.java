package com.BookMyShow.app.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Movie extends Exposed{
    private String name;
    private Integer durationMinutes;
}
