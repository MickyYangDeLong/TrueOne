package study.designpattern.singleton;

/**
 * @Auther Micky
 * @Date 2020-06-20 21:15
 * 双重检查
 */
public class Singleton03 {
    private Singleton03() {
    }

    private static volatile Singleton03 singleton = new Singleton03();

    public Singleton03 getInstance() {
        if (null == singleton) {
            synchronized (Singleton03.class) {
                if (null == singleton) {
                    singleton = new Singleton03();
                }
            }
        }
        return singleton;
    }
}
