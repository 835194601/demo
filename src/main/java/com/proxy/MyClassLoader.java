package com.proxy;

/**
 * @author leiwang
 * @version 1.0
 * @Since 2019-09-26
 */
public class MyClassLoader extends ClassLoader {
    public Class<?> defineMyClass(byte[] b, int off, int len) {
        return super.defineClass(b, off, len);
    }
}
