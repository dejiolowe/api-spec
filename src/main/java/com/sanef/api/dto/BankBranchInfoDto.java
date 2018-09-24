package com.sanef.api.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class BankBranchInfoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String description;
	
	
	private String branchId;
	
	
	private String branchName;
	
	
	private String branchType;
	
	
	private String  street;
	
	
	private String city;
	
	
	private String countryCode;
	
	
	private String country;

	
	
	
	private int numberOfAtms;
	
	
	
	private String  latitude;
	
	private String longitude;
	
	
	private Set<ContactInfo> contactInfo;
	
	
	private Set<SocialMediaInfo> socialMediaInfo;
	
	
	private List<ExpansionField> expansionFields;
	
}
