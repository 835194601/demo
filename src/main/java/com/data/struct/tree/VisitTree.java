package com.data.struct.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author leiwang
 * @version 1.0
 * @since 2020-04-07
 */
public class VisitTree {
    public static Node root;

    public static void buildTree(Integer[] input) {
        if (input == null || input.length == 0) {
            return;
        }

        for (int i = 0; i < input.length; i++) {
            addNodeInTree(input[i]);
        }
    }

    public static void addNodeInTree(Integer val) {
        addNodeInTree(root, val);
    }

    public static Node addNodeInTree(Node<Integer> node, Integer val) {
        if (node == null) {
            return new Node<>(val);
        }

        Integer curVal = node.value;
        if (curVal < val) {
            node.left = addNodeInTree(node.left, val);
        } else if (curVal > val) {
            node.right = addNodeInTree(node.right, val);
        }

        return node;
    }

    /**
     * 前序遍历
     */
    public static void preOrderTraverse(Node<Integer> node) {
        if (node == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        while (node != null || !stack.empty()) {
            if (node != null) {
                System.out.println(node.value);
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    /**
     * 中序遍历
     */
    public static void inOrderTraverse(Node<Integer> node) {
        if (node == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        while (node != null || !stack.empty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                System.out.println(node.value);
                node = node.right;
            }
        }
    }

    /**
     * 后序遍历
     */
    public static void postOrderTraverse(Node<Integer> node) {
        if (node == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(node);
        // 错误写法
        /*Node next = null;
        while (next != null || !stack.isEmpty()) {
            next = node;
            if (node.left != null || node.right != null) {
                if (node.right != null) {
                    stack.push(node.right);
                    next = node.right;
                }
                if (node.left != null) {
                    stack.push(node.left);
                    next = node.left;
                }
            } else {
                System.out.println(node.value);
                node = stack.peek();
            }
        }*/

        Node<Integer> cur, pre = null;
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if ((cur.left == null && cur.right == null) || (pre != null && (pre == cur.left || pre == cur.right))) {
                System.out.println(cur.value);
                stack.pop();
                pre = cur;
            } else {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
    }

    /**
     * 层序遍历
     */
    public static void depthOrderTraverse(Node<Integer> node) {
        if (node == null) {
            return;
        }

        Queue<Node> list = new LinkedList<>();
        list.add(node);

        while (!list.isEmpty()) {
            Node cur = list.remove();
            System.out.println(cur.value);
            if (cur.left != null) {
                list.add(cur.left);
            }

            if (cur.right != null) {
                list.add(cur.right);
            }
        }
    }
}
