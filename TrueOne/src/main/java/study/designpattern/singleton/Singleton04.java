package study.designpattern.singleton;

/**
 * @Auther Micky
 * @Date 2020-06-20 21:15
 * 内部类
 */
public class Singleton04 {
    private Singleton04() {
    }

    private static class SingletonHolder {
        private final static Singleton04 SINGLETON = new Singleton04();
    }

    public Singleton04 getInstance() {
        return SingletonHolder.SINGLETON;
    }
}
