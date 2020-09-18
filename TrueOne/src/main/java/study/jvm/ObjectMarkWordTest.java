package study.jvm;
//import org.openjdk.jol.info.ClassLayout;

/**
 * @Auther Micky
 * @Date 2020-08-11 23:08
 * 一个对象占用几个字节
 */
public class ObjectMarkWordTest {
    public  static void main(String[] args) {
        Object object = new Object();
      //  System.out.println(ClassLayout.parseInstace(object).toPrintable());
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("add");
        System.out.println(threadLocal.get());

    }

    synchronized void m(){}
}
