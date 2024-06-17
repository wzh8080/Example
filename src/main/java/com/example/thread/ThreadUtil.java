package com.example.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author 56465
 * @Create 2024/6/17 14:59
 */
public class ThreadUtil {
    public static String getThreadName(){
        String name = Thread.currentThread().getName();
        String time = new SimpleDateFormat("HH:mm:ss").format(new Date());
        return time + " " + name;
    }
}
