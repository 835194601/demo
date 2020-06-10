package com.thread.num.test;

import java.util.concurrent.CountDownLatch;

public class Worker implements Runnable {


    private CountDownLatch countDownLatch;
    public Worker(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        try {
            while (countDownLatch.getCount() > 0) {
                System.out.println("-------------" + Thread.currentThread().getName());
                //do work
                TestUtil.doWorkByTime(Constants.WORK_TIME_MILLISECOND);
                //do block operation
                TestUtil.doBlockOperation(Constants.BLOCK_TIME_MILLISECOND);
                countDownLatch.countDown();
            }
        } catch (InterruptedException e) {
        }
    }
}
