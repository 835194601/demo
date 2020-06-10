package com.sohu.test;

import org.springframework.stereotype.Service;

@Service
public class DemoAnnotationService {
    @Action(name = "注解拦截的add操作", hello = "hello, 我在这")
    public void add() {
        System.out.println("调用了add方法");
    }
}
