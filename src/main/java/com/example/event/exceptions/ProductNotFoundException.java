package com.example.event.exceptions;

public class ProductNotFoundException extends Throwable {
    public ProductNotFoundException(String id) {
        super("Cannot found account number [" + id + "]");
    }
}
