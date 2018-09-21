package com.openbanking.api.ng.exception;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends  SanefApiException {

    public ResourceNotFoundException(final String message) {
        super(message);
    }

	public ResourceNotFoundException() {
		super();
	}

}
