package com.sanef.api.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class CashTransactionRequest implements Serializable{

	private String transactionId;
	
	private String type;
	
	private String description;
	
	private String accountNumber;
	
	private String agentReferenceId;
	
	private Double amount; 
	
}
