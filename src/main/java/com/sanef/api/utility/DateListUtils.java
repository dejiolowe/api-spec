package com.sanef.api.utility;


import java.util.ArrayList;
import java.util.List;

public class DateListUtils {

    public static List<LabelDataResponse> mapDataToMonth(List<LabelDataResponse> data) {
        List<LabelDataResponse> dataWithMonth = DateListUtils.generateMonthList();

        for(int i=0; i < data.size(); i++) {
            dataWithMonth.get(Integer.parseInt(data.get(i).getLabel()) - 1).setData(data.get(i).getData());
        }

        return dataWithMonth;
    }
    public static List<LabelDataResponse> generateMonthList() {
        List<LabelDataResponse> list = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            list.add(new LabelDataResponse(DateListUtils.getMonthStringValue(i), "0"));
        }
        return list;
    }

    public static String getMonthStringValue(int month) {
        switch (month) {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return "January";
        }
    }
}
