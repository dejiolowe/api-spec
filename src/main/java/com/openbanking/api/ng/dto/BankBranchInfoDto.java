package com.openbanking.api.ng.dto;

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

	
	
	
	private String id;
	
	
	private String name;
	
	
	private String type;
	
	
	private String  street;
	
	
	private String city;
	
	
	private String countryCode;
	
	
	private String country;
	
	
	private String website;
	
	
	private String category;
	
	
	private String rcNumber;
	
	
	private String swiftCode;
	
	
	private String nibssCode;
	
	
	private String cbnBankCode;
	
	
	private int numberOfBranches;
	
	
	private int numberOfAtms;
	
	
	private String dateOfIncooperation;
	
	
	private Set<SupportInfo> supportInfo;
	
	
	private Set<SocialMediaInfo> socialMediaInfo;
	
	
	private List<ExpansionField> expansionFields;
	
}
