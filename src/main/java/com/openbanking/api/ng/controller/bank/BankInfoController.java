package com.openbanking.api.ng.controller.bank;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.openbanking.api.ng.controller.BaseApiController;
import com.openbanking.api.ng.dto.BankBranchInfoDto;
import com.openbanking.api.ng.dto.BankinfoDto;
import com.openbanking.api.ng.service.BankService;
import com.openbanking.api.ng.vo.GenericFailureResponse;
import com.openbanking.api.ng.vo.GenericResponse;
import com.openbanking.api.ng.vo.GenericSuccessResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@Api(value = "/bank", description = "Bank/Branch related operations", consumes = "application/json", tags = {"bank"})
@RestController
@Slf4j
@RequestMapping(path="bank")
public class BankInfoController extends BaseApiController {

	@Autowired
	private BankService bankService;

	 @ApiOperation(value = "Bank General Information",
     response = BankBranchInfoDto.class)
@ApiResponses(value = {
     @ApiResponse(code = 404, message = "Bank Information not available")})
	@GetMapping
	@ResponseBody
	public GenericResponse<BankinfoDto> getBankInfo() {
		BankinfoDto bankInfo=bankService.getBankInfo();
		if(bankInfo==null) {
			return new GenericFailureResponse<>("Error processing request");
		}
		return new GenericSuccessResponse<BankinfoDto>("Request processed ok",bankInfo);
	}
	

    @ApiOperation(value = "Get all Branches of a Bank",
            response = BankBranchInfoDto.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Branch not found")})
	@GetMapping(path="/branches")
	public GenericResponse<List<BankBranchInfoDto>> getBankBranchInfos() {
		List<BankBranchInfoDto> bankInfo=bankService.getBranchInfo();
		if(bankInfo==null) {
			return new GenericFailureResponse<>("Error processing request");
		}
		return new GenericSuccessResponse<List<BankBranchInfoDto>>("Request processed ok",bankInfo);
	}
	
   

	
}
