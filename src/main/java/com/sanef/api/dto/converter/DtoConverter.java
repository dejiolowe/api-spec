package com.sanef.api.dto.converter;

import org.springframework.core.convert.converter.Converter;

public abstract class DtoConverter <S,T>  implements Converter<S,T> {

	
	public T convert(S usergroup) {
		throw new RuntimeException();
	}
	
	public S convertToEntity(T source, Object... objects) {
		throw new RuntimeException();
	}
}
