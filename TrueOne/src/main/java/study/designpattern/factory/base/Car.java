package study.designpattern.factory.base;

/**
 * @Auther Micky
 * @Date 2020-06-21 12:07
 */
public class Car implements Vehicle {
    @Override
    public Vehicle newInstance() {
        return new Car();
    }
}
