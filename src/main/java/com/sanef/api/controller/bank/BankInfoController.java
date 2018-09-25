package com.sanef.api.controller.bank;

import com.sanef.api.controller.BaseApiController;
import com.sanef.api.dto.BankBranchInfoDto;
import com.sanef.api.dto.BankinfoDto;
import com.sanef.api.service.BankService;
import com.sanef.api.vo.GenericFailureResponse;
import com.sanef.api.vo.GenericResponse;
import com.sanef.api.vo.GenericSuccessResponse;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value = "bank", description = "Bank/Branch related operations", consumes = "application/json", tags = {"Branch"})
@RestController
@Slf4j
@RequestMapping(path = "/bank")
public class BankInfoController extends BaseApiController {

    @Autowired
    private BankService bankService;

    @ApiOperation(value = "General Information about the bank", response = BankBranchInfoDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Bank Information not available")
    })
    @GetMapping("")
    public GenericResponse<BankinfoDto> getBankInfo() {
        BankinfoDto bankInfo = bankService.getBankInfo();
        if (bankInfo == null) {
            return new GenericFailureResponse<>("Error processing request");
        }
        return new GenericSuccessResponse<>("Request processed ok", bankInfo);
    }

    @ApiOperation(value = "Get all Branches of a Bank",
            response = BankBranchInfoDto.class, responseContainer = "List")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Branch not found")})
    @GetMapping(path = "/branches")
    public GenericResponse<List<BankBranchInfoDto>> getBankBranchInfos() {
        List<BankBranchInfoDto> bankInfo = bankService.getBranchInfo();
        if (bankInfo == null) {
            return new GenericFailureResponse<>("Error processing request");
        }
        return new GenericSuccessResponse<>("Request processed ok", bankInfo);
    }


    @ApiOperation(value = "Gets get a specific branch by its branch ID",
            response = BankBranchInfoDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Branch not found"),
            @ApiResponse(code = 400, message = "Invalid Branch ID specified"),
            @ApiResponse(code = 200, response = BankBranchInfoDto.class, message = "Branch Information")})
    @GetMapping(path = "/branches/{branch-id}")
    public GenericResponse<BankBranchInfoDto> getBranchById(@PathVariable("branch-id") @ApiParam(value = "The Branch ID", required = true) String branchId) {
        List<BankBranchInfoDto> bankInfo = bankService.getBranchInfo();
        if (bankInfo == null) {
            return new GenericFailureResponse<>("Error processing request");
        }
        return new GenericSuccessResponse<>("Request processed ok", bankInfo.get(0));
    }


}
