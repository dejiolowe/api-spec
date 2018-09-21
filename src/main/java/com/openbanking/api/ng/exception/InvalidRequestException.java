package com.openbanking.api.ng.exception;

import lombok.Data;

@Data
public class InvalidRequestException extends SanefApiException {

	public InvalidRequestException(String message) {
		super(message);
	}
	
	
}