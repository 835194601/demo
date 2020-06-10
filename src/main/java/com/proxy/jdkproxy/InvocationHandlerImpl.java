package com.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author leiwang
 * @version 1.0
 * @Since 2019-09-26
 */
public class InvocationHandlerImpl implements InvocationHandler {
    private ElectricCar car;

    public InvocationHandlerImpl(ElectricCar car) {
        this.car = car;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("You are going to invoke " + method.getName() + "...");
        method.invoke(car, null);
        System.out.println(method.getName() + " invocation Has Been Finished...");
        return null;
    }
}
