package com.BookMyShow.app.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CustomerProfile extends Audit{
    String fullName;
    String city;
    String phone;
    String email;

    private User user;


}
