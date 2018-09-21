package com.openbanking.api.ng.utility;


import java.util.ArrayList;
import java.util.List;

public class GraphUtils {

    public static List<LabelDataResponse> generateGraphData(List<Object[]> objects) {
        List<LabelDataResponse> salesResponseList = new ArrayList<>();

        for (Object[] result : objects) {
            salesResponseList.add(new LabelDataResponse(result[0].toString(), result[1].toString()));
        }

        return DateListUtils.mapDataToMonth(salesResponseList);
    }
}
