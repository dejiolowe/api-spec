package com.openbanking.api.ng.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class BankAccountOpeningResponse implements Serializable {

	private final static long serialVersionUID = 8802982190366919463L;

	
	private String accountNumber;

	
	private String customerId;

	
	private String process;
	
	
	private String dateProcessed;
	
	
	private String dateRequested;
	
	
	
	private String status;

}