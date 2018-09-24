package com.sanef.api.exception;

@SuppressWarnings("serial")
public class RecordAlreadyExistsException extends  SanefApiException {

    public RecordAlreadyExistsException(final String message) {
        super(message);
    }

}
