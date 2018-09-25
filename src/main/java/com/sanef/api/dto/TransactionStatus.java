package com.sanef.api.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TransactionStatus implements Serializable {

    private String transactionId;

    private String type;

    private String description;

    private String accountNumber;

    private String agentReferenceId;

    private String transactionDate;

    private String process;

    private String processCode;

    private String processMessage;
}
