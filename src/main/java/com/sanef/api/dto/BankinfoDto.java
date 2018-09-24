package com.sanef.api.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class BankinfoDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String bankName;
	
	
	private String description;
	
	
	private String  street;
	
	
	private String city;
	
	
	private String countryCode;
	
	
	private String country;
	
	
	private String website;
	
	
	private String category;
	
	
	private String rcNumber;
	
	private String  latitude;
	
	private String longitude;
	
	
	private String swiftCode;
	
	
	private String nibssCode;
	
	
	private String cbnBankCode;
	
	
	private int numberOfBranches;

	
	
	private String incorporationDate;
	
	private String logo;
	
	private String bankCategory;
	
	  
	
	
	private Set<ContactInfo> contactInfo;
	
	
	private Set<SocialMediaInfo> socialMediaInfo;
	
	
	private List<ExpansionField> expansionFields;
	
}
