package com.sanef.api.controller;

import com.sanef.api.controller.BaseApiController;
import com.sanef.api.dto.BankAccountOpeningRequest;
import com.sanef.api.dto.BankAccountOpeningResponse;
import com.sanef.api.dto.BankAccountProductDto;
import com.sanef.api.service.BankService;
import com.sanef.api.vo.GenericFailureResponse;
import com.sanef.api.vo.GenericResponse;
import com.sanef.api.vo.GenericSuccessResponse;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "/account")
@Api(value = "Account", description = "Account related operations", consumes = "application/json", produces = "application/json", tags = {"Account"})
public class AccountController extends BaseApiController {

    @Autowired
    private BankService bankService;


    @ApiOperation(value = "Opens a new account",
            notes = "The status returned as part of the response data needs to be processed. i.e the account though opened might not be ready to be used when processing a transaction",
            response = BankAccountOpeningResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid data supplied")
    })
    @PutMapping(path = "")
    public GenericResponse<BankAccountOpeningResponse> openNewBankAccount(@Valid @RequestBody BankAccountOpeningRequest openingRequest) {
        BankAccountOpeningResponse bankInfo = bankService.openAccount(openingRequest);
        return new GenericSuccessResponse<>("Account opened successfully", bankInfo);
    }

    @ApiOperation(value = "Account Opening Status by Request ID", response = BankAccountOpeningResponse.class, nickname = "Get a single Account")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid requestId supplied"),
            @ApiResponse(code = 404, message = "Account Not Found"),
            @ApiResponse(code = 200, response = BankAccountOpeningResponse.class, message = "Account Information")
    })
    @GetMapping(path = "/requestId/{request-id}/status")
    public GenericResponse<BankAccountOpeningResponse> findAccountByRequestId(@PathVariable("request-id") @ApiParam(value = "Account opening requestId", required = true) String requestId) {
        BankAccountOpeningResponse bankInfo = bankService.getAccountByRequestId(requestId);
        return new GenericSuccessResponse<>("Account found", bankInfo);
    }


    @ApiOperation(value = "Account Opening Status by NUBAN", response = BankAccountOpeningResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Account Number supplied"),
            @ApiResponse(code = 404, message = "Account Not Found"),
            @ApiResponse(code = 200, response = BankAccountOpeningResponse.class, message = "Account Status Information")
    })
    @GetMapping(path = "/nuban/{account-number}/status")
    public GenericResponse<BankAccountOpeningResponse> findAccountByAccountNumber(@PathVariable("account-number") @ApiParam(value = "The Account Number", required = true) String accountNumber) {
        BankAccountOpeningResponse bankInfo = bankService.getAccountByRequestId(accountNumber);
        return new GenericSuccessResponse<>("Account found", bankInfo);
    }


    @ApiOperation(value = "Get all Account products",
            response = BankAccountProductDto.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Account Products not found")
    })
    @GetMapping(path = "/types")
    public GenericResponse<List<BankAccountProductDto>> getAccountProducts() {
        List<BankAccountProductDto> bankInfo = bankService.getAccountProducts();
        if (bankInfo == null) {
            return new GenericFailureResponse<>("Error processing request");
        }
        return new GenericSuccessResponse<>("Request processed ok", bankInfo);
    }


    @ApiOperation(value = "Gets a specified  account product", response = BankAccountProductDto.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Account Products not found")
    })
    @GetMapping(path = "/types/{type-id}")
    public GenericResponse<BankAccountProductDto> getAccountProductById(@PathVariable("type-id") String typeId) {
        List<BankAccountProductDto> bankInfo = bankService.getAccountProducts();
        if (bankInfo == null) {
            return new GenericFailureResponse<>("Error processing request");
        }
        return new GenericSuccessResponse<>("Request processed ok", bankInfo.get(0));
    }


}
