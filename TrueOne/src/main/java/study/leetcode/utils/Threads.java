package study.leetcode.utils;

public class Threads {
    private Threads() {
    }

    public static void setName(String name) {
        Thread.currentThread().setName(name);
    }
}
