package com.sanef.api.exception;

public class InactiveCustomerException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    public InactiveCustomerException(String message) {
        super(message);
    }
}
