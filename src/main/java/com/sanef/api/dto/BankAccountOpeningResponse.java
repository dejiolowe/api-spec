package com.sanef.api.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class BankAccountOpeningResponse implements Serializable {

    private final static long serialVersionUID = 8802982190366919463L;

    private String accountNumber;

    private String customerId;

    private String process;

    private String dateProcessed;

    private String dateRequested;

    private String status;

}