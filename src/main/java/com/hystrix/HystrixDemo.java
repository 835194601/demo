package com.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;

public class HystrixDemo extends HystrixCommand<String> {

    private final String name;

    public HystrixDemo(String name) {
//        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup").andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE));
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                // since we're doing an in-memory cache lookup we choose SEMAPHORE isolation
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE) //设置使用信号量隔离策略
                        .withExecutionIsolationSemaphoreMaxConcurrentRequests(3)  //设置信号量隔离时的最大并发请求数
                        .withFallbackIsolationSemaphoreMaxConcurrentRequests(5)     //设置fallback的最大并发数
                        .withExecutionTimeoutInMilliseconds(5000)));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
//        Thread.sleep(500);
        System.out.println("run:()" + Thread.currentThread().getName());
        return "hello" + name;
    }

    @Override
    protected String getFallback() {
        System.out.println(" getFallback" + Thread.currentThread().getName());
        return "exeucute Falled";
    }

    public static void main(String[] args) {
        System.out.println("main:{}" + Thread.currentThread().getName());
        for (int i = 0; i < 20; i++) {
            final int a = i;
            new Thread(() -> {
                try {
                    mtheod(a);
                } catch (Exception e) {
                }
            }).start();
        }
    }

    private static void mtheod(int i) {
        String result = new HystrixDemo("test" + i).execute();
        System.out.println(Thread.currentThread().getName() + "{}:name:{}" + result);

    }
}
