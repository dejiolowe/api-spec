package com.sanef.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import com.sanef.api.dto.BankAgency;
import com.sanef.api.dto.NextOfKin;
import com.sanef.api.dto.LinkedCard;



@Data
public class BankAccountOpeningRequest implements Serializable {

	@NotNull
	private String requestId;

	public String accountTypeId;

	public String firstName;

	public String otherName;

	public String surname;
	
	private String title;

	public String gender;

	public String dateOfBirth;

	public String bvn;

	public String street;

	public String city;

	public String localGovernment;

	public String country;

	public String nationality;

	public String phone;

	public String email;

	public NextOfKin nextOfKin;

	public String cardSerialNumber;
	
	private final static long serialVersionUID = 8802982190366919463L;

	public BankAgency agency;
	
	private LinkedCard linkedCard;
}