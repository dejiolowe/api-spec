package com.openbanking.api.ng.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NameValuePair implements Serializable {

	

	private Object value;
	
	private String key;
}
