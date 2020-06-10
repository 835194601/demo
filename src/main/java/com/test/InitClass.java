package com.test;

import com.data.struct.tree.Node;

/**
 * @author leiwang
 * @version 1.0
 * @Since 2020-04-19
 */
public class InitClass {
}

class Parent {

    int x = 10;

    public Parent() {
        add(2);
    }

    void add(int y) {
        x += y;
    }
}

class Child extends Parent {
    int x = 9;
    Node node = new Node(1);

    void add(int y) {
        x += y;
        System.out.println(x);
        System.out.println(node);
    }

    public static void main(String[] args) {
        Parent p = new Child();
        System.out.println(p.x);
        System.out.println();
    }
}
