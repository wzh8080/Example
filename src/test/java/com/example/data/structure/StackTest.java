package com.example.data.structure.structure;/**
 * Author:King
 * Create:2024/5/21 20:25
 */

import org.junit.Test;

import java.util.Stack;

/**
 * @Author: King
 * @Create: 2024/5/21 20:25
 */
public class StackTest {
    @Test
    public void test() {
        Stack<Integer> stack = new Stack<>();
        Integer push = stack.push(1);
        stack.push(2);
        int topElement = stack.pop();
        int peekElement = stack.peek();
        boolean isEmpty = stack.empty();
        int index = stack.search(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        Integer a = 2;
        stack.remove(a);
        System.out.println(stack);
        System.out.println(stack.get(2));
    }
}
