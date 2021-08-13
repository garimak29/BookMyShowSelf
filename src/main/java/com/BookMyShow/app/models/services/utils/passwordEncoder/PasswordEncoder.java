package com.BookMyShow.app.models.services.utils.passwordEncoder;

//Strategy pattern
public interface PasswordEncoder {
    String encode(String password);
}
