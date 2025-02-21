package com.example.collection;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Author zh wang
 * @Create 2025/2/20 14:50
 */
public class CollectionTest {
    private JSONObject getJsonExample() {
        JSONObject json = new JSONObject();
        json.put("key1", "value1");
        json.put("key2", "value2");
        json.put("key3", "value3");
        return json;
    }
    @Test
    /**
     * 替换 map 中的 key：删除旧key ，添加新key
     * ==> 不能在循环中修改 map，否则异常 ConcurrentModificationException
     */
    public void test01() throws JSONException {
        JSONObject json = getJsonExample();
        // 报错 ConcurrentModificationException
        //for (String key : json.keySet()) {
        //    if (key.equals("key2")) {
        //        String val = json.getString(key);
        //        json.remove(key);
        //        json.put("newKey", val);
        //    }
        //}

        // 报错 ConcurrentModificationException
        //Iterator<String> it = json.keySet().iterator();
        //while (it.hasNext()) {
        //    String key = it.next();
        //    if (key.equals("key2")) {
        //        String val = json.getString(key);
        //        json.remove(key);
        //        json.put("newKey", val);
        //    }
        //}

        HashSet<String> set = new HashSet<>();
        set.addAll(json.keySet());
        for (String key : set) {
            if (key.equals("key2")) {
                String val = json.getString(key);
                json.remove(key);
                json.put("newKey", val);
            }
        }
        System.out.println("json = " + json);

        List<Object> list = Arrays.asList("a", "b", "c");
        Collections.reverse(list);
        System.out.println("list = " + list);


    }
}
