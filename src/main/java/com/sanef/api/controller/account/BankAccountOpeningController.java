package com.sanef.api.controller.account;

import java.util.List;

import javax.validation.Valid;

import com.sanef.api.dto.BankAccountOpeningRequest;
import com.sanef.api.dto.BankAccountOpeningResponse;
import com.sanef.api.dto.BankAccountProductDto;
import com.sanef.api.vo.GenericFailureResponse;
import com.sanef.api.vo.GenericResponse;
import com.sanef.api.vo.GenericSuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanef.api.controller.BaseApiController;
import com.sanef.api.service.BankService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@RequestMapping(path="account")
@Api(value = "Account", description = "Account related operations", consumes = "application/json", produces = "application/json", tags = {"Account"})
public class BankAccountOpeningController extends BaseApiController {

	@Autowired
	private BankService bankService;


	@ApiOperation(value = "Opens a new account",
            notes = "The status returned as part of the response data needs to be processed. i.e the account though opened might not be ready to be used when processing a transaction",
            response = BankAccountOpeningResponse.class)
    @ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid data supplied")})
	@PutMapping(path="/open")
	public GenericResponse<BankAccountOpeningResponse> openNewBankAccount(@Valid @RequestBody BankAccountOpeningRequest openingRequest) {
		BankAccountOpeningResponse bankInfo=bankService.openAccount(openingRequest);
		return new GenericSuccessResponse<BankAccountOpeningResponse>("Account opened successfully",bankInfo);
	}
	
	@ApiOperation(value = "Account Opening Status by Request ID",
		     response = BankAccountOpeningResponse.class, nickname = "Get a single Account")
		@ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid requestId supplied"),
		     @ApiResponse(code = 404, message = "Account Not Found"), @ApiResponse(code = 200, response = BankAccountOpeningResponse.class, message = "Account Information")})
	@GetMapping(path="/account/status/requestID/{requestId}")
	public GenericResponse<BankAccountOpeningResponse> findAccountByRequestId(@PathVariable  @ApiParam(value = "Account opening requestId", required = true) String requestId) {
		BankAccountOpeningResponse bankInfo=bankService.getAccountByRequestId(requestId);
		return new GenericSuccessResponse<BankAccountOpeningResponse>("Account found",bankInfo);
	}
	

	
	
	
	 @ApiOperation(value = "Account Opening Status by NUBAN",
     response = BankAccountOpeningResponse.class)
@ApiResponses(value = {@ApiResponse(code = 400, message = "Invalid Account Number supplied"),
     @ApiResponse(code = 404, message = "Account Not Found"), @ApiResponse(code = 200, response = BankAccountOpeningResponse.class, message = "Account Status Information")})
	 @GetMapping(path="/account/status/nuban/{accountNumber}")
	public GenericResponse<BankAccountOpeningResponse> findAccountByAccountNumber(@PathVariable  @ApiParam(value = "The Account Number", required = true) String accountNumber) {
		BankAccountOpeningResponse bankInfo=bankService.getAccountByRequestId(accountNumber);
		return new GenericSuccessResponse<BankAccountOpeningResponse>("Account found",bankInfo);
	}
	
	
	 @ApiOperation(value = "Get all Account products",
	            response = BankAccountProductDto.class, responseContainer = "List")
	    @ApiResponses(value = {
	            @ApiResponse(code = 404, message = "Account Products not found")})
		@GetMapping(path="/types")
		public GenericResponse<List<BankAccountProductDto>> getAccountProducts() {
			List<BankAccountProductDto> bankInfo=bankService.getAccountProducts();
			if(bankInfo==null) {
				return new GenericFailureResponse<>("Error processing request");
			}
			return new GenericSuccessResponse<List<BankAccountProductDto>>("Request processed ok",bankInfo);
		}
		
		
	 @ApiOperation(value = "Gets a specified  account product",
	            response = BankAccountProductDto.class, responseContainer = "List")
	    @ApiResponses(value = {
	            @ApiResponse(code = 404, message = "Account Products not found")})
		@GetMapping(path="/types/{accountTypeId}")
		public GenericResponse<BankAccountProductDto> getAccountProductById(@PathVariable String accountTypeId) {
			List<BankAccountProductDto> bankInfo=bankService.getAccountProducts();
			if(bankInfo==null) {
				return new GenericFailureResponse<>("Error processing request");
			}
			return new GenericSuccessResponse<BankAccountProductDto>("Request processed ok",bankInfo.get(0));
		}
		
	
}
