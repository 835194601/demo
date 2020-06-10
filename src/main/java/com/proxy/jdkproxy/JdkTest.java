package com.proxy.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * @author leiwang
 * @version 1.0
 * @Since 2019-09-26
 */
public class JdkTest {
    public static void main(String[] args) throws Exception {
        ElectricCar car = new ElectricCar();
        ClassLoader classLoader = car.getClass().getClassLoader();
        Class<?>[] interfaces = car.getClass().getInterfaces();
        InvocationHandlerImpl invocationHandler = new InvocationHandlerImpl(car);
        Object o = Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        Vehicle vehicle = (Vehicle) o;
        vehicle.drive();
        Rechargable rechargable = (Rechargable) o;
        rechargable.recharge();

        ProxyUtils.generateClassFile(car.getClass(), "ElecticCarProxy");
    }
}
