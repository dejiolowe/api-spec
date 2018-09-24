package com.sanef.api.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class CashTransactionValidationResponse implements Serializable{

private String transactionId;
	
	
	private String accountNumber;

	private String referenceId;
	
	private String transactionDate;
	
	private String process;
	
	private String processCode;
	
	private String processMessage;
}
