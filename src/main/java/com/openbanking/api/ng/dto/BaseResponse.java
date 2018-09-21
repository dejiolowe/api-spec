package com.openbanking.api.ng.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T> implements Serializable {

    
    private static final long serialVersionUID = 1L;

    private T data;

    private String status;

    protected String responseCode;

    protected String responseMsg;
}
