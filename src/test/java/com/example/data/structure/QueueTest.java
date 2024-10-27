package com.example.data.structure;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;

/**
 * 队列
 * @Author: King
 * @Create: 2024/5/21 19:36
 */
public class QueueTest {

    @Test
    public void doArrayDequeTest(){
        // 创建一个容量为 3 的队列
        ArrayDeque<Integer> queue = new ArrayDeque<>(3);
        // 添加元素
        queue.add(1);
        queue.addFirst(0);
        queue.addLast(2);
        queue.offer(2);
        queue.offerFirst(3);
        System.out.println("容量已满："+queue);
        // 队列满时，再添加元素
        queue.add(4);
        queue.offerFirst(5);
        queue.offerLast(6);
        System.out.println("容量已满，再添加元素："+queue);
        // 队列为空时，再删除元素
        queue.poll();
        // 获取队首元素
        queue.peek();
        // 获取队尾元素
        queue.element();

    }
    /*
     * 链表实现队列
     * LinkedList 实现了 Queue 接口
     */
    @Test
    public void doLinkedListTest(){
        LinkedList<Integer> queue = new LinkedList<>();
    }
}
