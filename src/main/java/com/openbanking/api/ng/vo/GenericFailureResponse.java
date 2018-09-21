package com.openbanking.api.ng.vo;

import lombok.Data;
import org.springframework.validation.ObjectError;

import java.util.List;

@Data
public class GenericFailureResponse<T> extends GenericResponse {

	public GenericFailureResponse(final String message) {
		this(message, null);
	}

	public GenericFailureResponse(final String message, final T data) {
		this(message, null,data);
	}

	public GenericFailureResponse(final String message, final String code, final T data) {
		super(message);
		setStatus("fail");
		setData(data);
		setCode(code);
	}

	public GenericFailureResponse(List<ObjectError> allErrors, String message) {
		super(allErrors, message);
		setStatus("fail");
	}

}
