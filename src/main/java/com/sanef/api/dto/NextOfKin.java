package com.sanef.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class NextOfKin implements Serializable {

	public String nextOfKinName;

	public String nextOfKinGender;

	public String nextOfKinAddress;

	public String nextOfKinEmail;

	public String nextOfKinPhone;

	public String nextOfKinRelationship;
	
	
}