package com.sanef.api.exception;

import lombok.Data;

@Data
public class InvalidRequestException extends SanefApiException {

	public InvalidRequestException(String message) {
		super(message);
	}
	
	
}