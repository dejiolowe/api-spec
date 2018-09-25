package com.sanef.api.service;


import com.sanef.api.dto.*;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    private final DataService dataService;

    public TransactionService(DataService dataService) {
        this.dataService = dataService;
    }

    public CashTransactionResponse cashOutAuthRequest(CashTransactionRequest cashTransactionRequest) throws Exception {
        return this.dataService.getData("txnAuthRes.json", CashTransactionResponse.class);
    }

    public CashTransactionValidationResponse cashOutAuth(CashTransactionAuthRequest cashTransactionRequest) throws Exception {
        return this.dataService.getData("txnOtpRes.json", CashTransactionValidationResponse.class);
    }

    public CashTransactionResponse cashInAuthRequest(CashTransactionRequest cashTransactionRequest) throws Exception {
        return this.dataService.getData("txnAuthRes.json", CashTransactionResponse.class);
    }

    public TransactionStatus getTransaction(String transactionId) throws Exception {
        return this.dataService.getData("txnAuthRes.json", TransactionStatus.class);
    }

}
