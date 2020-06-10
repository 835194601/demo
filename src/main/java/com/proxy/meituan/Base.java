package com.proxy.meituan;

import java.lang.management.ManagementFactory;

/**
 * @author leiwang
 * @version 1.0
 * @since 2019-09-30
 */
public class Base {
    public static void main(String[] args) {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String s = name.split("@")[0];
        //打印当前Pid
        System.out.println("pid:"+s);
        while (true) {
            try {
                Thread.sleep(5000L);
            } catch (Exception e) {
                break;
            }
            process();
        }
    }

    public static void process() {
        System.out.println("process");
    }

//    public void process() {
//        System.out.println("process");
//    }
}