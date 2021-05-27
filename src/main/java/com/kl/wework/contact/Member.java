package com.kl.wework.contact;

import io.restassured.response.Response;

import java.util.Arrays;
import java.util.HashMap;

import static org.hamcrest.Matchers.equalTo;

public class Member extends Contact {
    public String random=String.valueOf(System.currentTimeMillis());
    public Response create(HashMap<String, Object> map) {
        System.out.println("create--------");
        String body = template("/data/member.json",map);
        System.out.println("111");
        reset();
        return requestSpecification
                .body(body)
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/user/create")
                .then().extract().response();
    }

}
