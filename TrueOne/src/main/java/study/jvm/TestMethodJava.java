package study.jvm;

/**
 * @Auther Micky
 * @Date 2020-09-13 0:05
 */
public class TestMethodJava {
    public static void main(String[] args) {
     /*   String a = "java1";
        String b = "java1";
        System.out.println(a);
        System.out.println(b);
        System.out.println(a == b);
        System.out.println(a.intern() == a);
        System.out.println(b.intern() == a);
        System.out.println(b.intern() == b);
        System.out.println("=============");*/
        String str1 = new StringBuilder("ja").append("va1").toString();
        System.out.println(str1.intern() == str1);
        String str12 = new StringBuilder("ja").append("va1").toString();
        System.out.println(str12.intern() == str12);
        System.out.println(str1 == str12);
        String a = "java1";
        String b = new String("java1");
        System.out.println(a==str1);
        System.out.println(a==str12);
        System.out.println(b==str12);
        System.out.println(b==str12);
        System.out.println(b==str12);

    }
}
