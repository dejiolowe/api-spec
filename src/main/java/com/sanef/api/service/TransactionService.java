package com.sanef.api.service;


import com.sanef.api.dto.CashTransactionAuthRequest;
import com.sanef.api.dto.CashTransactionRequest;
import com.sanef.api.dto.CashTransactionResponse;
import com.sanef.api.utility.ObjectMapperUtil;
import org.springframework.stereotype.Service;

import com.sanef.api.dto.CashTransactionValidationResponse;

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
