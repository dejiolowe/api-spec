package com.sanef.api.controller;

import com.sanef.api.dto.*;
import com.sanef.api.service.TransactionService;
import com.sanef.api.vo.GenericResponse;
import com.sanef.api.vo.GenericSuccessResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
@Api(value = "transaction", description = "Transaction related operations", consumes = "application/json", tags = {"Transactions"})
public class TransactionController {

    @Autowired
    private TransactionService transactionService;


    @ApiOperation(value = "Start the processing of Cash-out for customer", response = CashTransactionResponse.class, nickname = "Cash out Auth Request")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Transaction Id"),
            @ApiResponse(code = 404, message = "Account Not Found"),
            @ApiResponse(code = 200, response = CashTransactionResponse.class, message = "Request processed successfully")
    })
    @RequestMapping(value = "/cash-out", method = RequestMethod.POST)
    public GenericResponse<CashTransactionResponse> cashOutAuthRequest(@RequestBody CashTransactionRequest cashTransactionRequest) throws Exception {
        CashTransactionResponse cResponse = transactionService.cashOutAuthRequest(cashTransactionRequest);
        return new GenericSuccessResponse<>("Request Processed Successfully", cResponse);
    }


    @ApiOperation(value = "Authorize cash-out or cash-in transaction",
            response = CashTransactionResponse.class, nickname = "Cashout Auth Validate")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Transaction Id"),
            @ApiResponse(code = 404, message = "Account Not Found"),
            @ApiResponse(code = 200, response = CashTransactionValidationResponse.class, message = "Request processed successfully")
    })
    @PostMapping(value = "/cash-out/{transaction-id}/authorize")
    public GenericResponse<CashTransactionValidationResponse> cashOutRequestAuthValidation(@RequestBody CashTransactionAuthRequest cashTransactionRequest, @PathVariable("transaction-id") String transactionId) throws Exception {
        cashTransactionRequest.setTransactionId(transactionId);
        CashTransactionValidationResponse cResponse = transactionService.cashOutAuth(cashTransactionRequest);
        return new GenericSuccessResponse<>("Request Processed Successfully", cResponse);
    }


    @ApiOperation(value = "Process cash-in for customer", response = CashTransactionResponse.class, nickname = "Cash-In Auth Request")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Transaction Id"),
            @ApiResponse(code = 404, message = "Account Not Found"),
            @ApiResponse(code = 200, response = CashTransactionResponse.class, message = "Request processed successfully")
    })
    @PostMapping(value = "/cash-in")
    public GenericResponse<CashTransactionResponse> cashInAuthRequest(@RequestBody CashTransactionRequest cashTransactionRequest) throws Exception {
        CashTransactionResponse cResponse = transactionService.cashInAuthRequest(cashTransactionRequest);
        return new GenericSuccessResponse<>("Request Processed Successfully", cResponse);
    }

    @ApiOperation(value = "Get Transaction", response = CashTransactionResponse.class, nickname = "Get Transaction")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid Transaction Id"),
            @ApiResponse(code = 404, message = "Transaction Not Found"),
            @ApiResponse(code = 200, response = CashTransactionResponse.class, message = "Request processed successfully")
    })
    @GetMapping(value = "/{transaction-id}")
    public GenericResponse<TransactionStatus> getTransaction(@PathVariable("transaction-id") String transactionId) throws Exception {
        TransactionStatus transaction = transactionService.getTransaction(transactionId);
        return new GenericSuccessResponse<>("Request Processed Successfully", transaction);
    }

}
