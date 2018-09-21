package com.openbanking.api.ng.service;


import org.springframework.stereotype.Service;

import com.openbanking.api.ng.dto.CashTransactionAuthRequest;
import com.openbanking.api.ng.dto.CashTransactionRequest;
import com.openbanking.api.ng.dto.CashTransactionResponse;
import com.openbanking.api.ng.dto.CashTransactionValidationResponse;
import com.openbanking.api.ng.utility.ObjectMapperUtil;

@Service
public class TransactionService extends BaseService {



	public CashTransactionResponse cashOutAuthRequest(CashTransactionRequest cashTransactionRequest) throws Exception{
		return ObjectMapperUtil.getObjectMapper().readValue(getOBNDataFile("txnAuthRes.json"),
				CashTransactionResponse.class);
	}

	public CashTransactionValidationResponse cashOutAuth(CashTransactionAuthRequest cashTransactionRequest) throws Exception{
		return ObjectMapperUtil.getObjectMapper().readValue(getOBNDataFile("txnOtpRes.json"),
				CashTransactionValidationResponse.class);
	}

	public CashTransactionResponse cashInAuthRequest(CashTransactionRequest cashTransactionRequest) throws Exception{
		return ObjectMapperUtil.getObjectMapper().readValue(getOBNDataFile("txnAuthRes.json"),
				CashTransactionResponse.class);
	}

}
