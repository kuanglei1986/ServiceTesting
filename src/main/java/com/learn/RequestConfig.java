package com.learn;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class RequestConfig {

    //设置请求的地址和端口号
    public void setHttpURIandPortValue(String URI){
        RestAssured.baseURI =URI;

    }

    //发送get请求
    public Response setGet(Map setParams, String URI){
        return RestAssured.given().params(setParams).when().get(URI);
    }

    //发送post请求
    public Response setPost(Map setParams,String URI) {
        return RestAssured.given().params(setParams).when().post(URI);
    }
}


