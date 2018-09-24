package com.sanef.api.service;

import com.sanef.api.dto.*;
import com.sanef.api.utility.ObjectMapperUtil;
import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BankService {

    @Value("${OPB_HOME:}")
    private String OPB_HOME;

    public BankinfoDto getBankInfo() {
        try {
            return ObjectMapperUtil.getObjectMapper().readValue(getOBNDataFile("bankinfo.json"),
                    BankinfoDto.class);
        } catch (Exception e) {

        }
        return null;
    }

    public List<BankBranchInfoDto> getBranchInfo() {
        try {
            return ObjectMapperUtil.getObjectMapper().readValue(getOBNDataFile("branchinfos.json"),
                    List.class);
        } catch (Exception e) {

        }
        return ListUtils.EMPTY_LIST;
    }

    public List<BankAccountProductDto> getAccountProducts() {
        try {
            return ObjectMapperUtil.getObjectMapper().readValue(getOBNDataFile("accountProducts.json"),
                    List.class);
        } catch (Exception e) {

        }
        return ListUtils.EMPTY_LIST;
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

    private File getOBNDataFile(String dataFile) throws Exception {
        if (StringUtils.isEmpty(OPB_HOME)) {
            ClassPathResource classPathResource = new ClassPathResource(String.format("OPB_HOME/data/%s", dataFile));
            return classPathResource.getFile();
        } else {
            return new File(OPB_HOME);
        }
    }

}
