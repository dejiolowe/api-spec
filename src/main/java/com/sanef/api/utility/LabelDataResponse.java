package com.sanef.api.utility;

import lombok.Data;

@Data
public class LabelDataResponse {

    private String label;

    private String data;


    public LabelDataResponse(String label, String data) {
        this.label = label;
        this.data = data;
    }
}
