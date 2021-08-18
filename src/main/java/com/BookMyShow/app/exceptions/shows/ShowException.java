package com.BookMyShow.app.exceptions.shows;

import com.BookMyShow.app.exceptions.BookMyShowException;

import java.awt.print.Book;

public class ShowException extends BookMyShowException {

    public ShowException(String message) {
        super(message);
    }
}
