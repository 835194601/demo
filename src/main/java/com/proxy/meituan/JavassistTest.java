package com.proxy.meituan;

import javassist.*;

import java.io.IOException;

/**
 * @author leiwang
 * @version 1.0
 * @Since 2019-09-30
 */

public class JavassistTest {
    public static void main(String[] args) throws NotFoundException, CannotCompileException, IllegalAccessException, InstantiationException, IOException {
        Base base = new Base();

        ClassPool cp = ClassPool.getDefault();
        CtClass cc = cp.get("com.proxy.meituan.Base");
        CtMethod m = cc.getDeclaredMethod("process");
        m.insertBefore("{ System.out.println(\"start\"); }");
        m.insertAfter("{ System.out.println(\"end\"); }");
        Class c = cc.toClass();
        cc.writeFile("/Users/apple/Downloads/demo/src/main/java/com/proxy");
        Base h = (Base)c.newInstance();
        h.process();
    }
}
