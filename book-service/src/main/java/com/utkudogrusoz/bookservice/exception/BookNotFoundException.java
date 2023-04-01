package com.utkudogrusoz.bookservice.exception;

public class BookNotFoundException extends RuntimeException {

    public BookNotFoundException(String s) {
        super(s);
    }
}
