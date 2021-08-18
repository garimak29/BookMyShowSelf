package com.BookMyShow.app.dtos;

import lombok.Data;

@Data
public class UpdateCustomerDTO {
    String fullName;
    String city;
    String phone;
    String email;
}
