package com.BookMyShow.app.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
public class Role extends Audit{
    private String Role;
    private String description;


}
