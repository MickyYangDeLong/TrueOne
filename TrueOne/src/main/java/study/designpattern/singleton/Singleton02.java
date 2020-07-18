package study.designpattern.singleton;

/**
 * @Auther Micky
 * @Date 2020-06-20 21:15
 * 饿汉模式
 */
public class Singleton02 {
    private Singleton02(){}
    private static Singleton02 singleton = new Singleton02();
/**第二中方式
   static {
        singleton = new singleton02();
    }*/
    public Singleton02 getInstance(){
        return singleton;
    }
}
