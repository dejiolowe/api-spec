package com.openbanking.api.ng.utility;

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
