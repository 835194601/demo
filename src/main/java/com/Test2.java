package com;

/**
 * @author leiwang
 * @version 1.0
 * @Since 2019-09-30
 */
public class Test2 {
    public static int b = 0;

    public static int c = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("begin");
            while (c == 0) {
//                int x = b;
                System.out.println("------");
                try {
                    Thread.sleep(300);
                } catch (Exception e) {

                }

//                synchronized (Test2.class) {
//                    int i = 0;
////                    System.out.println(c);
//                }
//                System.out.println(i);
            }
            System.out.println("c1 = " + c);
        }).start();



        Thread.sleep(100);
        System.out.println("c2 = " + c);
        c = 1;
        Thread.sleep(100);
        System.out.println("c3 = " + c);
//        new Thread(() -> {
//            System.out.println("begin");
//            while (c == 0) {
////                int x = b;
//            }
//            System.out.println("c4 = " + c);
//        }).start();
        Thread.sleep(100);
        Thread.sleep(100);
        Thread.sleep(100);
        System.gc();
    }
}
