package com.BookMyShow.app.exceptions.validations;

public class PasswordLengthException extends ValidationException {
    public PasswordLengthException(String message) {
        super(message);
    }
}
