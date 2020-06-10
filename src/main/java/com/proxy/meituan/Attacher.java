package com.proxy.meituan;

/**
 * @author leiwang
 * @version 1.0
 * @Since 2019-09-30
 */
import com.sun.tools.attach.AgentInitializationException;
import com.sun.tools.attach.AgentLoadException;
import com.sun.tools.attach.AttachNotSupportedException;
import com.sun.tools.attach.VirtualMachine;

import java.io.IOException;

public class Attacher {
    public static void main(String[] args) throws AttachNotSupportedException, IOException, AgentLoadException, AgentInitializationException {
        // 传入目标 JVM pid
        VirtualMachine vm = VirtualMachine.attach("3829");
        vm.loadAgent("/Users/apple/Downloads/demo/out/artifacts/unnamed/unnamed.jar");
        Base base = new Base();
        base.toString();
        Base.process();
    }
}