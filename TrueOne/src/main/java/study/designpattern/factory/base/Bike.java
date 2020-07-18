package study.designpattern.factory.base;

/**
 * @Auther Micky
 * @Date 2020-06-21 12:07
 */
public class Bike implements Vehicle {
    @Override
    public Vehicle newInstance() {
        return new Bike();
    }
}
