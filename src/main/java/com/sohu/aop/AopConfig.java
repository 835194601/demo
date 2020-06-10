package com.sohu.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.sohu.test")
@EnableAspectJAutoProxy
public class AopConfig {

}
