package com.BookMyShow.app.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data

public class CreateUserDTO {
    @NonNull
    String username;
    @NonNull
    String password;


}
