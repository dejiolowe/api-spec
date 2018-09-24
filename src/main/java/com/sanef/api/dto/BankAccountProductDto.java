package com.sanef.api.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class BankAccountProductDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String accountTypeId;

	
	private String accountTypeName;

	
	private String minimumBalance;

	
	private String maximumOutflowLimit;

	
	private String maximumBalance;

	
	private String maximumInFlowLimit;

	
	private String decimal;
	
	private String currency;

	
	private String kycLevel;

	
	private boolean ussd;
	
	private boolean mobileApp;
	
	private boolean atm;
	
	private boolean localWeb;
	
	private boolean internationalWeb;

	
	
	private List<AccountOpeningDocumentationDto> documentationRequired;

	private List<DigitalServicesDto> digitalServices;
	
	
	private List<CardProductsDto> cardProducts;

	
	private List<ExpansionField> expansionFields;

}
