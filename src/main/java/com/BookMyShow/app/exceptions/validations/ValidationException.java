package com.BookMyShow.app.exceptions.validations;

import com.BookMyShow.app.exceptions.BookMyShowException;

public class ValidationException extends BookMyShowException {


    public ValidationException(String message) {
        super(message);
    }
}
