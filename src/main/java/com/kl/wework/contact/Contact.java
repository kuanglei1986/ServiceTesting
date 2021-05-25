package com.kl.wework.contact;

import com.kl.wework.Restful;
import com.kl.wework.Wework;
import io.restassured.http.ContentType;

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
