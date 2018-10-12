package com.sanef.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class LinkedCard implements Serializable {

	public String type;

	public String description;

	public String serial;
	
}