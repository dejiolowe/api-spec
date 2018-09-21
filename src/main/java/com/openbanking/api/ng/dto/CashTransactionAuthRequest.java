package com.openbanking.api.ng.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class CashTransactionAuthRequest implements Serializable{

private String transactionId;

	private String accountNumber;
	
	private List<CashTransactionAuth> authorization;
	
	
}
