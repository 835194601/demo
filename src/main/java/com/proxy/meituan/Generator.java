package com.proxy.meituan;


import org.springframework.asm.ClassReader;
import org.springframework.asm.ClassVisitor;
import org.springframework.asm.ClassWriter;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author leiwang
 * @version 1.0
 * @Since 2019-09-30
 */


public class Generator {
    public static void main(String[] args) throws Exception {
        //读取
        ClassReader classReader = new ClassReader("com/proxy/meituan/Base");
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        //处理
        ClassVisitor classVisitor = new MyClassVisitor(classWriter);
        classReader.accept(classVisitor, ClassReader.SKIP_DEBUG);
        byte[] data = classWriter.toByteArray();
        //输出
        File f = new File("/Users/apple/Downloads/demo/target/classes/com/proxy/meituan/Base.class");
        FileOutputStream fout = new FileOutputStream(f);
        fout.write(data);
        fout.close();
        System.out.println("now generator cc success!!!!!");
    }
}
