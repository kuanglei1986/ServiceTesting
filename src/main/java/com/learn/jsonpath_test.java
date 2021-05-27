package com.learn;

import com.jayway.jsonpath.JsonPath;

import java.util.List;

public class jsonpath_test {
    public static void main(String[] args) {
        String json1 = "{\"store\": {\n" +
                "\"book\": [ \n" +
                "{ \"category\": \"reference\",\n" +
                "\"author\": \"Nigel Rees\",\n" +
                "        \"title\": \"Sayings of the Century\",\n" +
                "        \"price\": 8.95\n" +
                "      },\n" +
                "      { \"category\": \"fiction\",\n" +
                "        \"author\": \"Evelyn Waugh\",\n" +
                "        \"title\": \"Sword of Honour\",\n" +
                "        \"price\": 12.99,\n" +
                "        \"isbn\": \"0-553-21311-3\"\n" +
                "      }\n" +
                "    ],\n" +
                "    \"bicycle\": {\n" +
                "      \"color\": \"red\",\n" +
                "      \"price\": 19.95\n" +
                "    }\n" +
                "  }\n" +
                "}";
        System.out.println(json1);
        String author = JsonPath.read(json1, "$.store.book[0].author");
        System.out.println(author);
        List<String> authors = JsonPath.read(json1, "$.store.book[*].author");
        List<String> authors1 = JsonPath.parse(json1).read("$.store.book[*].author");
        System.out.println(authors1);


    }

}
