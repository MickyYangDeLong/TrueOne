package study.designpattern.singleton;

/**
 * @Auther Micky
 * @Date 2020-06-20 21:15
 * 线程安全懒汉模式
 */
public class Singleton01 {
    private Singleton01(){}
    private static Singleton01 singleton;
    public synchronized Singleton01 getInstance(){
        if (null == singleton){
            singleton = new Singleton01();
        }
        return singleton;
    }
}
