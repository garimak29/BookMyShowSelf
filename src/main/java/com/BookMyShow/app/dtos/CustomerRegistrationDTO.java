package com.BookMyShow.app.dtos;

import lombok.Data;
import lombok.NonNull;

@Data
@NonNull
public class CustomerRegistrationDTO {
    String fullName;
    String city;
    String phone;
    String email;
    String username;
    String password;

}
