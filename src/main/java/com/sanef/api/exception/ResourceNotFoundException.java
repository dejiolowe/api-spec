package com.sanef.api.exception;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends  SanefApiException {

    public ResourceNotFoundException(final String message) {
        super(message);
    }

	public ResourceNotFoundException() {
		super();
	}

}
