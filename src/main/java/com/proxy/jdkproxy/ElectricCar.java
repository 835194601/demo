package com.proxy.jdkproxy;

/**
 * @author leiwang
 * @version 1.0
 * @Since 2019-09-26
 */
public class ElectricCar implements Rechargable, Vehicle {
    @Override
    public void recharge() {
        System.out.println("Electric Car is Moving silentLy....");
    }

    @Override
    public void drive() {
        System.out.println("Electric Car is Recharging...");
    }
}
