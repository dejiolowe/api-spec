package com.sanef.api.exception;

public class UnknownCompanyException extends RuntimeException {

    private static final long serialVersionUID = 5861310537366287163L;

    public UnknownCompanyException() {
        super();
    }

    public UnknownCompanyException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public UnknownCompanyException(final String message) {
        super(message);
    }

    public UnknownCompanyException(final Throwable cause) {
        super(cause);
    }
}