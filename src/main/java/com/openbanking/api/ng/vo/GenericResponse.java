package com.openbanking.api.ng.vo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import lombok.Data;

@Data
public class GenericResponse<T> {
	
	
	private String message;
	
	
	private String status;
	
	
	private String code;
	
	
	private T data;

	public GenericResponse(final String message) {
		this(message,null);
	}
	
	public GenericResponse(final String message,T data) {
		super();
		this.message = message;
		this.data=data;
	}

	
	public GenericResponse(List<ObjectError> allErrors, String message) {
		this.message = message;
		String temp = allErrors.stream().map(e -> {
			if (e instanceof FieldError) {
				return "{\"field\":\"" + ((FieldError) e).getField() + "\",\"defaultMessage\":\""
						+ e.getDefaultMessage() + "\"}";
			} else {
				return "{\"object\":\"" + e.getObjectName() + "\",\"defaultMessage\":\"" + e.getDefaultMessage()
						+ "\"}";
			}
		}).collect(Collectors.joining(","));
		this.message = "[" + temp + "]";
	}

}
