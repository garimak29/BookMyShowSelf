package com.BookMyShow.app.exceptions.accounts;


public class AccountAlreadyExistsException extends AccountException {
    public AccountAlreadyExistsException(String message) {
        super(message);
    }
}
