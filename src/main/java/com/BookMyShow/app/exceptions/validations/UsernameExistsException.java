package com.BookMyShow.app.exceptions.validations;

public class UsernameExistsException extends ValidationException {
    public UsernameExistsException(String message) {
        super(message);
    }
}
