package com;

/**
 * @author leiwang
 * @version 1.0
 * @Since 2019-11-14
 */
public class ExecuteOrder {
    public static void main(String[] args) {
        f1();
        System.out.println();
//        ExecuteOrder executeOrder = new ExecuteOrder();
//        ExecuteOrder executeOrder1 = new ExecuteOrder();
    }

    static {
        System.out.println("5");
        f1();
        main(null);
    }

    static ExecuteOrder javaTest = new ExecuteOrder();

    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    static int b = 200;

    ExecuteOrder() {
        System.out.println("3");
        System.out.println("a=" + a + ", b=" + b);
    }

//    static ExecuteOrder javaTest = new ExecuteOrder();

    public static void f1() {
        System.out.println("4");
    }

    int a = 100;

}
