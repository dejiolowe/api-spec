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

@Api(value = "/general/information", description = "Provides general information about the bank", consumes = "application/json", tags = {"General"})
@RestController
@Slf4j
@RequestMapping(path="/general/information")
public class GeneralInformationController extends BaseApiController {

	@Autowired
	private BankService bankService;

	 @ApiOperation(value = "General Information about the bank",
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
	

	
}
