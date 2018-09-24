package com.sanef.api.exception;

public final class ConversionException extends RuntimeException {

    private static final long serialVersionUID = 5861310537366287163L;

    public ConversionException() {
        super();
    }

    public ConversionException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ConversionException(final String message) {
        super(message);
    }

    public ConversionException(final Throwable cause) {
        super(cause);
    }

}
