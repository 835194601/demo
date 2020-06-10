package com.proxy;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;

/**
 * @author leiwang
 * @version 1.0
 * @Since 2019-09-26
 */
public class JavassistGenerator {
    public static void main(String[] args) throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.makeClass("com.proxy.Programmer");
        CtMethod method = CtNewMethod.make("public void code(){}", cc);
        method.insertBefore("System.out.println(\"Javassist I'm a Programmer, Just Coding......\");");
        cc.addMethod(method);
        cc.writeFile("/Users/apple/Downloads/demo/src/main/java/com/proxy");
    }
}
