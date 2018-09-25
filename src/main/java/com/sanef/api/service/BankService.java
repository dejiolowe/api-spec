package com.sanef.api.service;

import com.sanef.api.dto.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BankService {

    private final DataService dataService;

    public BankService(DataService dataService) {
        this.dataService = dataService;
    }

    public BankinfoDto getBankInfo() {
        return this.dataService.getData("bankinfo.json", BankinfoDto.class);
    }

    public List<BankBranchInfoDto> getBranchInfo() {
        return this.dataService.getData("branchinfos.json", List.class);
    }

    public List<BankAccountProductDto> getAccountProducts() {
        return this.dataService.getData("accountProducts.json", List.class);
    }

    public BankAccountOpeningResponse openAccount(BankAccountOpeningRequest openingRequest) {
        BankAccountOpeningResponse respose = new BankAccountOpeningResponse();
        respose.setAccountNumber(RandomStringUtils.randomNumeric(10));
        respose.setCustomerId(RandomStringUtils.randomAlphabetic(1) + RandomStringUtils.randomNumeric(8));
        DateFormat format = new SimpleDateFormat("DD/MM/YYYY");
        respose.setDateProcessed(format.format(new Date()));
        respose.setStatus("ACTIVE");
        respose.setProcess("BATCH");
        respose.setDateRequested(format.format(new Date()));
        return respose;
    }

    public BankAccountOpeningResponse getAccountByRequestId(String requestId) {
        BankAccountOpeningResponse respose = new BankAccountOpeningResponse();
        respose.setAccountNumber(RandomStringUtils.randomNumeric(10));
        respose.setCustomerId(RandomStringUtils.randomAlphabetic(1) + RandomStringUtils.randomNumeric(8));
        DateFormat format = new SimpleDateFormat("DD/MM/YYYY");
        respose.setDateProcessed(format.format(new Date()));
        respose.setStatus("ACTIVE");
        respose.setProcess("BATCH");
        respose.setDateRequested(format.format(new Date()));
        return respose;
    }

}
