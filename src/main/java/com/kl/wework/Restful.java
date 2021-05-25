package com.kl.wework;

import io.restassured.specification.RequestSpecification;
import jdk.nashorn.internal.ir.RuntimeNode;

import javax.xml.ws.Response;
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


}
