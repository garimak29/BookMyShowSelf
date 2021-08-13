package com.BookMyShow.app.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AdminProfile extends Audit{
    private String designation;
    private String phone1, phone2, phone3;
    private Long numberOfYearsInTheCompany;

    private User user; // this profile belongs to this user
}
