package study.codewars;

import java.util.ArrayList;
import java.util.List;

public class Line {

    public static String Tickets(int[] peopleInLine) {
        if (peopleInLine == null || peopleInLine.length < 2) {
            return "YES";
        }
        List<String> list = new ArrayList<>();
        list.add(String.valueOf(peopleInLine[0]));
        int customerMoney;
        for (int i = 1; i < peopleInLine.length; i++) {
            customerMoney = peopleInLine[i];
            switch (customerMoney){
                case 25:
                    list.add("25");
                    break;
                case 50:
                    if (!list.contains("25")){
                        return "NO";
                    }
                    list.remove("25");
                    list.add("50");
                    break;
                case 100:
                    if (list.contains("25") && list.contains("50")){
                        list.remove("25");
                        list.remove("50");
                    }else if (list.contains("25")){
                        list.remove("25");
                        list.remove("25");
                        if (!list.remove("25")){
                            return "NO";
                        }
                    }else{
                        return "NO";
                    }
                    break;

                default:
                    break;
            }
        }
        return "YES";
    }
}
