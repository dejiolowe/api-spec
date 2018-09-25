package com.sanef.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CashTransactionAuthRequest implements Serializable {

    @JsonIgnore
    private String transactionId;

    private String accountNumber;

    private List<CashTransactionAuth> authorization;


}
