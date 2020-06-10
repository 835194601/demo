package com.sohu.test;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LogAspect {
    @Pointcut("@annotation(com.sohu.test.Action)")
    public void annotationPointcut() {

    }

    @After("annotationPointcut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Action annotation = method.getAnnotation(Action.class);
        System.out.println("注解拦截" + annotation.name());
        System.out.println("????: " + annotation.hello());
    }

}
