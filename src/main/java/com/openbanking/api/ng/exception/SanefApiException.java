package com.openbanking.api.ng.exception;

public class SanefApiException extends RuntimeException{
	
	public SanefApiException() {
        super();
    }

    public SanefApiException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public SanefApiException(final String message) {
        super(message);
    }

    public SanefApiException(final Throwable cause) {
        super(cause);
    }
}
