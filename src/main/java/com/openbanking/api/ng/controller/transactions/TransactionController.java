package com.openbanking.api.ng.controller.transactions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.openbanking.api.ng.dto.CashTransactionAuthRequest;
import com.openbanking.api.ng.dto.CashTransactionRequest;
import com.openbanking.api.ng.dto.CashTransactionResponse;
import com.openbanking.api.ng.dto.CashTransactionValidationResponse;
import com.openbanking.api.ng.service.TransactionService;
import com.openbanking.api.ng.vo.GenericResponse;
import com.openbanking.api.ng.vo.GenericSuccessResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/transactions")
@Api(value = "/transaction", description = "Transaction related operations", consumes = "application/json", tags = {"Transactions"})
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	
	 @ApiOperation(value = "Start the processing of Cash-out for customer",
		     response = CashTransactionResponse.class, nickname = "Cashout Auth Request")
		@ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid Transaction Id"),
		     @ApiResponse(code = 404, message = "Account Not Found"), @ApiResponse(code = 200, response = CashTransactionResponse.class, message = "Request processed successfully")})
    @RequestMapping(value = "/cashout/", method = RequestMethod.POST)
    public GenericResponse<CashTransactionResponse> cashOutAuthRequest(@RequestBody CashTransactionRequest cashTransactionRequest) throws Exception {
		CashTransactionResponse cResponse=transactionService.cashOutAuthRequest(cashTransactionRequest);
		return new GenericSuccessResponse<CashTransactionResponse>("Request Processed Sucessfully",cResponse);
    }
	 
	 
	 @ApiOperation(value = "Authorize cash-out or cash-in transaction",
		     response = CashTransactionResponse.class, nickname = "Cashout Auth Validate")
		@ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid Transaction Id"),
		     @ApiResponse(code = 404, message = "Account Not Found"), @ApiResponse(code = 200, response = CashTransactionValidationResponse.class, message = "Request processed successfully")})
    @RequestMapping(value = "/cashout/authorize/{transactionId}", method = RequestMethod.POST)
    public GenericResponse<CashTransactionValidationResponse> cashOutRequestAuthValidation(@RequestBody CashTransactionAuthRequest cashTransactionRequest) throws Exception {
		 CashTransactionValidationResponse cResponse=transactionService.cashOutAuth(cashTransactionRequest);
		return new GenericSuccessResponse<CashTransactionValidationResponse>("Request Processed Sucessfully",cResponse);
    }
	 
	 
	 
	 @ApiOperation(value = "Process cash-in for customer",
		     response = CashTransactionResponse.class, nickname = "Cash-In Auth Request")
		@ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid Transaction Id"),
		     @ApiResponse(code = 404, message = "Account Not Found"), @ApiResponse(code = 200, response = CashTransactionResponse.class, message = "Request processed successfully")})
    @RequestMapping(value = "/cashin/", method = RequestMethod.POST)
    public GenericResponse<CashTransactionResponse> cashInAuthRequest(@RequestBody CashTransactionRequest cashTransactionRequest) throws Exception {
		CashTransactionResponse cResponse=transactionService.cashInAuthRequest(cashTransactionRequest);
		return new GenericSuccessResponse<CashTransactionResponse>("Request Processed Sucessfully",cResponse);
    }
	 
	 
	 
}
