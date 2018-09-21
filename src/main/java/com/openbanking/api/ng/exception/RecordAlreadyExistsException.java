package com.openbanking.api.ng.exception;

@SuppressWarnings("serial")
public class RecordAlreadyExistsException extends  SanefApiException {

    public RecordAlreadyExistsException(final String message) {
        super(message);
    }

}
