package com.proxy.jdkproxy;

import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * @author leiwang
 * @version 1.0
 * @Since 2019-09-26
 */
public class ProxyUtils {
    public static void generateClassFile(Class clazz, String proxyName) throws Exception {
        byte[] classFile = ProxyGenerator.generateProxyClass(proxyName, clazz.getInterfaces());
        String path = clazz.getResource(".").getPath();
        System.out.println(path);
        FileOutputStream out = new FileOutputStream(path + proxyName + ".class");
        out.write(classFile);
        out.flush();
        out.close();
    }
}
