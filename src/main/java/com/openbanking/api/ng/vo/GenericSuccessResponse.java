package com.openbanking.api.ng.vo;

import lombok.Data;

@Data
public class GenericSuccessResponse<T> extends GenericResponse<T> {
	

	public GenericSuccessResponse(final String message) {
		this(message,null);
	}

	public GenericSuccessResponse(final String message,T data) {
		super(message);
		setMessage(message);
		setStatus("success");
		setCode("00");
		this.setData(data);
	}
	
	
}
