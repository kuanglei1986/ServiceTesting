package com.kl.wework;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.specification.RequestSpecification;
import jdk.nashorn.internal.ir.RuntimeNode;

import javax.xml.ws.Response;
import java.rmi.server.RemoteServer;
import java.util.Arrays;
import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

public class Restful {
    public String url;
    public String method;
    public HashMap<String, String> headers;
    public HashMap<String, String> query=new HashMap<String, String>();
    public String body;
    public RequestSpecification requestSpecification = given();

    public Response send() {
        query.entrySet().forEach(entry -> {
            requestSpecification.queryParam(entry.getKey(),entry.getValue());
        });

        return (Response) requestSpecification.when().request("get","www.baidu.com");
    }

    public static String template(String path, HashMap<String, Object> map) {
        DocumentContext documentContext = JsonPath.parse(Restful.class
                .getResourceAsStream(path));
        System.out.println(documentContext);
        map.entrySet().forEach(entry -> {
            documentContext.set(entry.getKey(), entry.getValue());
        });
        return documentContext.jsonString();
    }

    public static void main(String[] args) {
        HashMap<String,Object> map = new HashMap<>();
        String nameNew="test111";
        String random=String.valueOf(System.currentTimeMillis()).substring(5+0, 5+8);
        map.put("userid", nameNew);
        map.put("name", nameNew);
        map.put("department", Arrays.asList(1, 2));
        map.put("mobile", "151"+ random);
        map.put("userid", nameNew);
        map.put("email", random + "@qq.com");
        System.out.println("start------------");
        String body = template("/data/member.json",map);
    }


}
