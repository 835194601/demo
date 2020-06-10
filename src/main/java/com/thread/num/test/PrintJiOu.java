package com.thread.num.test;

/**
 * @author leiwang
 * @version 1.0
 * @Since 2020-05-23
 */
public class PrintJiOu {
    private static Integer share = 0;

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (share < 100) {
                    try {
                        synchronized (share) {
                            if (share % 2 == 0) {
                                System.out.println(Thread.currentThread().getName() + "---" + share);
                                share++;
                                share.wait();
                            } else {
//                                share++;
//                                wait();
                                share.notify();
                            }
                        }
                    } catch (Exception e) {
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (share < 100) {
                    try {
                        synchronized (share) {
                            if (share % 2 != 0) {
                                System.out.println(Thread.currentThread().getName() + "---" + share);
                                share++;
                                share.wait();
                            } else {
//                                wait();
                                share.notify();
                            }
                        }
                    } catch (Exception e) {
                    }

                }
            }
        });

        t1.start();
        t2.start();
    }
}
