package com.proxy;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author leiwang
 * @version 1.0
 * @Since 2019-09-26
 */
public class MyTest {
    public static void main(String[] args) throws Exception {
//        InputStream inputStream = new FileInputStream("/Users/apple/Downloads/demo/target/classes/com/proxy/Programmer.class");
        Programmer p = new Programmer();
        InputStream inputStream = new FileInputStream("/Users/apple/Downloads/demo/src/main/java/com/proxy/com/proxy/Programmer.class");
        byte[] result = new byte[1024];
        int count = inputStream.read(result);
        MyClassLoader loader = new MyClassLoader();
        Class<?> clazz = loader.defineMyClass(result, 0, count);
        System.out.println(clazz.getCanonicalName());
        Object o = clazz.newInstance();
        clazz.getMethod("code", null).invoke(o, null);
    }
}
