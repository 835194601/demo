package com.test;

/**
 * @author leiwang
 * @version 1.0
 * @Since 2019-11-30
 */
public class ThreadLocalThread {
    public final static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public final static InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("123");
        System.out.println(threadLocal.get());
//        inheritableThreadLocal.set("12");
        inheritableThreadLocal.set("1234");
        MyThread myThread = new MyThread();
        myThread.start();

    }
}

class MyThread extends Thread {
//    ThreadLocal<String> threadLocal;
//    InheritableThreadLocal<String> inheritableThreadLocal;
//
//    public MyThread(ThreadLocal<String> threadLocal, InheritableThreadLocal<String> inheritableThreadLocal) {
//        super();
//        this.threadLocal = threadLocal;
//        this.inheritableThreadLocal = inheritableThreadLocal;
//    }

    @Override
    public void run() {
        System.out.println(ThreadLocalThread.threadLocal.get());
        System.out.println(ThreadLocalThread.inheritableThreadLocal.get());
    }
}
