package com.BookMyShow.app.models;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class Customer extends Exposed{
    String fullName;
    String city;
    String phone;
    String email;
    @NonNull
    private User user;


    public Customer(User user) {
       this.user = user;
    }
}
