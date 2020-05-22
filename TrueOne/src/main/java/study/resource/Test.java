package study.resource;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        LinkedHashMap<String,String> hashMapResource  = new LinkedHashMap<>();
        hashMapResource.put("a","a");
        hashMapResource.put("b","a");
        hashMapResource.put("c","a");
        System.out.println(hashMapResource);
        hashMapResource.entrySet();
        for (Map.Entry<String,String> map:hashMapResource.entrySet()){
            System.out.println(map.getKey()+"=="+map.getValue());
        }
    }
}
