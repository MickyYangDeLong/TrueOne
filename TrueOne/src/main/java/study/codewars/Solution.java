package study.codewars;

import java.lang.StringBuilder;
class Solution{

    static String toCamelCase(String s){
        if(null == s || s.isEmpty()){
            return "";
        }
        String[] arr = s.split("-|_");
        StringBuilder sb = new StringBuilder();
        if (arr.length >=2){
            sb.append(arr[0]);
            String temp;
            for(int i=1;i<arr.length;i++){
                temp = arr[i];
                sb.append(temp.substring(0,1).toUpperCase()).append(temp.substring(1));
            }
            return sb.toString();
        }
        return s;
    }
}
