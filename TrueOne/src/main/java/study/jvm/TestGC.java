package study.jvm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestGC {
    static int _1MB = 1024 * 1024;

    private static Map<Integer, Integer> cache = new ConcurrentHashMap<>(15);
    public static void main(String[] args) {
     /*   byte[] allco = new byte[1024 * _1MB];
        System.out.println(">>>>> " + allco);*/
        System.out.println(fibonaacci(80));
    }
    public static int fibonaacci(Integer i) {
        if (i == 0 || i == 1) {
            return i;
        }
        return cache.computeIfAbsent(i, (key) -> {
            System.out.println("fibonaacci : " + key);
            return fibonaacci(key - 1) + fibonaacci(key - 2);
        });
    }


}
