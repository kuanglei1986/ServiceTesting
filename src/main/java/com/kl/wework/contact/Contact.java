package com.kl.wework.contact;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.kl.wework.Restful;
import com.kl.wework.Wework;
import io.restassured.http.ContentType;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class Contact extends Restful {
    public Contact() {
        reset();
    }

    public void reset(){
        requestSpecification = given()
                .log().all()
                .queryParam("access_token", Wework.getToken())
                .contentType(ContentType.JSON);
    }


}
