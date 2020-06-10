package com.hystrix;

import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixObservableCommand;
import rx.Observable;
import rx.Subscriber;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class HelloWorldHystrixObservableCommand extends HystrixObservableCommand<String> {

    private final String name;

    protected HelloWorldHystrixObservableCommand(String name) {
        super(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"));
        this.name = name;
    }

    @Override
    protected Observable<String> construct() {
        System.out.println("in construct! thread:" + Thread.currentThread().getName());
        return (Observable<String>) Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> observer) {
                try {
                    System.out.println("in call of construct! thread:" + Thread.currentThread().getName());
                    if (!observer.isUnsubscribed()) {
                        observer.onError(getExecutionException());  // 直接抛异常退出，不会往下执行
                        observer.onNext("Hello1" + " thread:" + Thread.currentThread().getName());
                        observer.onNext("Hello2" + " thread:" + Thread.currentThread().getName());
                        observer.onNext(name + " thread:" + Thread.currentThread().getName());
                        System.out.println("complete before------" + " thread:" + Thread.currentThread().getName());
                        observer.onCompleted(); // 不会往下执行observer的任何方法
                        System.out.println("complete after------" + " thread:" + Thread.currentThread().getName());
                        observer.onCompleted(); // 不会执行到
                        observer.onNext("abc"); // 不会执行到
                    }
                } catch (Exception e) {
                    observer.onError(e);
                }
            }
        });
    }

    public static void main(String[] args) throws Exception {
//        Observable<String> observable = new HelloWorldHystrixObservableCommand("test").observe();
//        observable.subscribe(new Subscriber<String>() {
//            @Override
//            public void onCompleted() {
//                System.out.println("completed");
//            }
//
//            @Override
//            public void onError(Throwable throwable) {
//                System.out.println("error-----------" + throwable);
//            }
//
//            @Override
//            public void onNext(String v) {
//                System.out.println("next------------" + v);
//            }
//        });

//        // queue()是异步非堵塞性执行：直接返回，同时创建一个线程运行HelloWorldHystrixCommand.run()
//        // 一个对象只能queue()一次
//        // queue()事实上是toObservable().toBlocking().toFuture()
        Future<String> future = new HystrixDemo("Hlx").queue();
//
//        // 使用future时会堵塞，必须等待HelloWorldHystrixCommand.run()执行完返回
        String queueResult = future.get(10000, TimeUnit.MILLISECONDS);
//        // String queueResult = future.get();
        System.out.println("queue异步结果：" + queueResult);
////        assertEquals("hello", queueResult.substring(0, 5));
    }
}
