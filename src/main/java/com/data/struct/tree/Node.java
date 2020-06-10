package com.data.struct.tree;

/**
 * @author leiwang
 * @version 1.0
 * @Since 2020-04-07
 */
public class Node<T> {
    public T value;
    public Node left;
    public Node right;

    public Node(T value) {
        this.value = value;
    }
}
