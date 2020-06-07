package study.algorithm;

public class Test {
    int a=1;
    int ab=1;
    int c = a + ab;
    public static void main(String[] args) {
        int a=1;
        int ab=1;
        int c = a + ab;
        System.out.println(c);
        System.out.println("abcde");
        out("121321");
        System.out.println(Test.class.getClassLoader());
    }

    private static void out(String s) {
        int a=1;
        int ab=1;
        int c = a + ab;
        System.out.println(c);
        System.out.println(s);
    }
}
