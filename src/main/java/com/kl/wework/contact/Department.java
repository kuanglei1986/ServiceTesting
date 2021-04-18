package com.kl.wework.contact;


import com.kl.wework.Wework;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.*;

public class Department {
//    查询部门
    public Response list(String id) {
       return given().log().all()
                .param("access_token", Wework.getToken())
                .param("id","")
        .when().get("https://qyapi.weixin.qq.com/cgi-bin/department/list")
                .then().log().all().statusCode(200).extract().response();

    }

    //    创建部门
    public Response create(String name, String parentId) {
        return given().log().all()
                .queryParam("access_token", Wework.getToken())
                .body("{\n" +
                " \"name\": " + name + ",\n"+
                " \"parentid\": " + parentId + "\n"+
                "}")
                .when().post("https://qyapi.weixin.qq.com/cgi-bin/department/create")
                .then().log().all().statusCode(200).extract().response();

    }

    //    删除部门
    public Response delete(String id) {
        return given().log().all()
                .param("access_token", Wework.getToken())
                .param("id",id)
                .when().get("https://qyapi.weixin.qq.com/cgi-bin/department/delete")
                .then().log().all().statusCode(200).extract().response();

    }


}
