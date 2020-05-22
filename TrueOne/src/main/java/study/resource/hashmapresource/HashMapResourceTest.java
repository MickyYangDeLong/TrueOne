package study.resource.hashmapresource;

import org.junit.Assert;
import org.junit.Test;

public class HashMapResourceTest {
    @Test
    public void Test1(){
        HashMapResource<String ,String> hashMapResource = new HashMapResource<>();
        hashMapResource.put("a","a");
        hashMapResource.put("b","a");
        hashMapResource.put("c","a");
        System.out.println(hashMapResource);
        Assert.assertEquals(3,hashMapResource.size);
    }
}
