package com.sanef.api.controller.transactions;

import com.sanef.api.dto.CashTransactionAuthRequest;
import com.sanef.api.dto.CashTransactionRequest;
import com.sanef.api.dto.CashTransactionResponse;
import com.sanef.api.dto.CashTransactionValidationResponse;
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
    @RequestMapping(value = "/cash-out/{transaction-id}/authorize", method = RequestMethod.POST)
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
    @RequestMapping(value = "/cash-in", method = RequestMethod.POST)
    public GenericResponse<CashTransactionResponse> cashInAuthRequest(@RequestBody CashTransactionRequest cashTransactionRequest) throws Exception {
        CashTransactionResponse cResponse = transactionService.cashInAuthRequest(cashTransactionRequest);
        return new GenericSuccessResponse<>("Request Processed Successfully", cResponse);
    }


}
