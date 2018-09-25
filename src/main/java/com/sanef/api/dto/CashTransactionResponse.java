package com.sanef.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CashTransactionResponse extends TransactionStatus implements Serializable {

    private List<CashTransactionAuthType> authType;

}
