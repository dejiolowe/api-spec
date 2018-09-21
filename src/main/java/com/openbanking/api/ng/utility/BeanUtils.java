package com.openbanking.api.ng.utility;

import com.fasterxml.jackson.databind.ObjectReader;

public class BeanUtils {

	public static <T> T  copyProperties(Object src,Class<T> des) throws Exception {
		return ObjectMapperUtil.getObjectMapper()
		.readValue(ObjectMapperUtil.getObjectMapper().writeValueAsString(src), des);
	} 
	
	public static <T> T  copyProperties(Object source,T des) throws Exception {
		T defaults = (T) ObjectMapperUtil.getObjectMapper().readValue(ObjectMapperUtil.getObjectMapper().writeValueAsString(des), des.getClass());
		ObjectReader updater = ObjectMapperUtil.getObjectMapper().readerForUpdating(defaults);
		T merged = updater.readValue(ObjectMapperUtil.getObjectMapper().writeValueAsString(source));
		return merged;
	} 
}
