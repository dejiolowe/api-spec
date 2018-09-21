package com.openbanking.api.ng.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.openbanking.api.ng.definition.ErrorCode;
import com.openbanking.api.ng.vo.GenericFailureResponse;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler
    public ResponseEntity<GenericFailureResponse> handle(Throwable throwable) {
    	GenericFailureResponse errorResponse = new GenericFailureResponse(throwable.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
