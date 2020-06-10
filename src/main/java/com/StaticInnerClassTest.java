package com;

/**
 * @author leiwang
 * @version 1.0
 * @Since 2019-11-25
 */
public class StaticInnerClassTest {

    public static void main(String[] args) {
        OuterClassTest.InnerClass instance1 = new OuterClassTest.InnerClass();
        OuterClassTest.InnerClass instance2 = new OuterClassTest.InnerClass("qwe");
        System.out.println(instance1);
        System.out.println(instance2);
        OuterClassTest outerClassTest = new OuterClassTest();
        OuterClassTest outerClassTest1 = new OuterClassTest();
        System.out.println(outerClassTest.innerClass);
        System.out.println(outerClassTest1.innerClass);
    }
}

class OuterClassTest {
    OuterClassTest.InnerClass innerClass;

    public OuterClassTest() {
        if (innerClass == null) {
            innerClass = new OuterClassTest.InnerClass();
        }
    }

    final public static class InnerClass {
        String name = "abc";
        public InnerClass() {}
        public InnerClass(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
