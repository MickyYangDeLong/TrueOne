package study.designpattern.factory;

import study.designpattern.factory.base.Bike;
import study.designpattern.factory.base.Car;
import study.designpattern.factory.base.Truck;
import study.designpattern.factory.base.Vehicle;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther Micky
 * @Date 2020-06-21 12:02
 * 简单工厂
 */
public class SimpleFactory {

    /*********************************001-静态工厂*************************************************/
    public enum VehicleType {
        BIKE, CAR, TRUCK;
    }

    public static Vehicle create(VehicleType type) {
        switch (type) {
            case BIKE:
                return new Bike();
            case CAR:
                return new Car();
            case TRUCK:
                return new Truck();
            default:
                return null;
        }
    }
    /*********************************001-静态工厂**************************************************/


    /*********************************002-反射机制注册简单工厂**************************************************/
    private Map<String, Class> registeredProducts = new HashMap<>();

    public void registerVehicle(String vehicleId, Class vehicleClass) {
        registeredProducts.put(vehicleId, vehicleClass);
    }

    public Vehicle createVehicle(String type) throws IllegalAccessException, InstantiationException {
        Class productClass = registeredProducts.get(type);
        return null != productClass ? (Vehicle) productClass.newInstance() : null;
    }
    /*********************************002-反射机制注册简单工厂**************************************************/


    /*********************************003-使用模板方法-静态工厂**************************************************/
    private Map<String,Vehicle> registeredProducts002 = new HashMap<>();
    public void registerVehicle(String vehicleId, Vehicle vehicle) {
        registeredProducts002.put(vehicleId, vehicle);
    }

    public Vehicle createVehicle002(String vehicle){
        return registeredProducts002.get(vehicle).newInstance();
    }

    /*********************************003-使用模板方法-静态工厂**************************************************/


}
