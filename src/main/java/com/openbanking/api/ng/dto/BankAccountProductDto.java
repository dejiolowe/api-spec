package com.openbanking.api.ng.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class BankAccountProductDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String id;

	
	private String name;

	
	private String minBalance;

	
	private String maxBalance;

	
	private String maxOutflowTxnLimit;

	
	private String maxInflowTxnLimit;

	
	private String currency;

	
	private String kycLevel;

	
	private boolean ussd;
	
	private boolean mobileApp;
	
	private boolean atm;
	
	private boolean localWeb;
	
	private boolean internationalWeb;

	
	private List<AccountOpeningDocumentationDto> documentations;

	
	private List<CardProductsDto> cardProducts;

	
	private List<ExpansionField> expansionFields;

}
