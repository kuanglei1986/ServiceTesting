package com.learn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class entry_test {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("1", "value1");
        map.put("2", "value2");
        map.put("3", "value3");

        //第一种：普遍使用，二次取值
        System.out.println("通过Map.keySet遍历key和value：");
        System.out.println(map);
        for (String key:map.keySet()) {
            System.out.println("key= "+ key + " and value= " + map.get(key));

        }

        //第二种
        System.out.println("通过Map.entrySet使用iterator遍历key和value：");
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

        //第三种：推荐，尤其是容量大时
        System.out.println("通过Map.entrySet遍历key和value");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
        }

//        在Java 8中， 你可以用forEach + lambda表达式来循环Map
        map.forEach((k,v) -> {
            System.out.println("key= " + k + " value= " + v);

        });

    }
}
