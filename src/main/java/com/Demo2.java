package com;

import com.alibaba.fastjson.JSONObject;

/**
 * @Author zh wang
 * @Create 2025/2/18 14:33
 */
public class Demo2 {
    public static void main(String[] args) {
        JSONObject json = new JSONObject();

        JSONObject json1 = new JSONObject();
        json1.put("name","zhangsan");
        json1.put("age","11");
        JSONObject json2 = new JSONObject();
        json2.put("name","lisi");
        json2.put("age","22");

        JSONObject j1 = new JSONObject();
        j1.put("people",json1);
        JSONObject j2 = new JSONObject();
        j2.put("people",json2);
        json.putAll(j1);
        json.putAll(j2);
        System.out.println("json = " + json);

        System.out.println("-----------");
        String a = "asdfasddfffaa";
        String s = a.replaceAll("a", "-");
        String s1 = a.replace("a", "-");
        System.out.println("s0 = " + s);
        System.out.println("s1 = " + s1);
    }
}
