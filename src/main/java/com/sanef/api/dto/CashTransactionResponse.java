package com.sanef.api.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class CashTransactionResponse implements Serializable{

private String transactionId;
	
	private String type;
	
	private String description;
	
	private String accountNumber;
	
	private String agentReferenceId;
	
	private List<CashTransactionAuthType> authType;
	
	private String transactionDate;
	
	private String process;
	
	private String processCode;
	
	private String processMessage;
}
