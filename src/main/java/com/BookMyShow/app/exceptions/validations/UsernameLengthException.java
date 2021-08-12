package com.BookMyShow.app.exceptions;

public class UsernameLengthException extends Throwable {
    public UsernameLengthException(String message) {
        return new BookMyShowException(message);
    }
}
