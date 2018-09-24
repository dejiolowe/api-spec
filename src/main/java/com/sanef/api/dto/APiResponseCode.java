package com.sanef.api.dto;

import java.util.HashMap;
import java.util.Map;


public enum APiResponseCode {
    SUCCESS("00", "SUCCESS"), TRANSACTION_FAILED("01", "TRANSACTION_FAILED"), BAD_REQUEST("02", "Bad Request"), 
    AUTHENTICATION_ERROR("04", "AUTHENTICATION_ERROR"), SYSTEM_ERROR("06", "System error"), 
    LIMIT_REACHED("07","Limit reached"), UNKNOWN_PAYMENT_REFERENCE("08", "Unknown payment reference"), 
    UNKNOWN_MANDATE_REFERENCE("09", "Unknown mandate reference"), 
    INSUFFICIENT_AMOUNT("10","Insufficient amount"),INVALID_AMOUNT("11","Invalid amount"),
    RESOURCE_NOT_FOUND("12", "Resource not found"), DUPLICATE_REQUEST_ERROR("13","Duplicate Request"), 
    AUTHENTICATION_EPIRED("14", "Authentication Expired"), REGISTRATION_ERROR("15","User registration error"),
    DUPLICATE_REGISTRATION_ERROR("16","Duplicate User registration error"),
    USER_VERIFICATION_REQUIRED("17","User verification required"), 
    UNKNOWN_TRANSACTION("22", "Unknown transaction"), 
    ALREADY_PROCESSED("23", "Already processed transaction"), 
    INVALID_REQUEST("24","Invalid Request.Missing headers or parameters"), ERROR_PROCESSING_REQUEST("25", "Error Processing Request"),
    UNKNOWN_MERCHANT("26","Unknown merchant"), ACCOUNT_NOT_LINKED_WITH_MERCHNAT("27","Bank account not linked with merchant"),
    UNKNOWN_BANK_ACCOUNT("28","Unknown bank account"), DECRYPTION_ERROR("29","Decryption error"),
    ACCOUNT_PENDING_AUTHORIZATION("30","Account pending authorization for merchant debit"),
    INVALID_CREDIT_ACCOUNT("31","Invalid credit account"), MISSING_REQUEST_PARAMETER("32","Missing request parameters"),
    INVALID_DEBIT_ACCOUNT("33","Invalid debit account"), 
    API_AUTHORIZATION_ERROR("34","Api autorization error"),API_HASHING_ERROR("34","Api Hashing Error"),
    REQUEST_TIME_EXPIRED("35","Request time stamp expired"),
    INVALID_REQUEST_TIMESTAMP("36","Invalid request time stamp format"), 
    UNAUTHORIZED_CREDIT_ACCOUNT("37","Unauthorized credit account"),
    UNAUTHORIZED_DEBIT_ACCOUNT("38","Unauthorized debit account"), 
    INVALID_DATE("40","Invalid Date"),
    INVALID_AUTHORISATION_ID("41","Invalid Authorisation ID"),
    INACTIVE_CUSTOMER("42","Inactive customer"),
    UNKNOWN_USER("7800","User record not found"), UNKNOWN_CUSTOMER("7801","Customer not found"),
    CUSTOMER_ALREADY_ENROLLED("7802","Customer already enrolled"), INVALID_LOAN_ID("7803","Customer already enrolled"),
    CUSTOMER_OPT_OUT("7804","Customer opted out of service"), RECORD_NOT_FOUND("7805","Record not found");
    private String code;

    private String description;


    APiResponseCode(String code, String description) {
        setCode(code);
        setDescription(description);
    }


    public static Map<String, APiResponseCode> getStatusCodeMap() {
        Map<String, APiResponseCode> map = new HashMap<>();
        for (APiResponseCode statusCode : APiResponseCode.values()) {
            map.put(statusCode.getCode(), statusCode);
        }
        return map;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
