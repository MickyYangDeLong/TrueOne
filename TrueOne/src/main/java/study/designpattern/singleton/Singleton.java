package study.designpattern.singleton;

/**
 * @Auther Micky
 * @Date 2020-06-20 21:15
 * 线程不安全懒汉模式
 */
public class Singleton {
    private Singleton(){}
    private static Singleton singleton;
    public Singleton getInstance(){
        if (null == singleton){
            singleton = new Singleton();
        }
        return singleton;
    }
}
