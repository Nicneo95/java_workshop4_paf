package com.example.exception;

public class OrderException extends Exception {
    public OrderException() {
        super();
    }

    public OrderException(String msg) {
        super(msg);
    }
}
