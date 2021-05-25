package com.kl.wework;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class Wework {
    private static String token;

    public static String getWeworkToken(String secret) {
        return given().log().all()
                .queryParam("corpid", WeworkConfig.getInstance().corId)
                .queryParam("corpsecret", secret)
                .when().get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
                .then().log().all().statusCode(200).body("errcode",equalTo(0))
                .extract().path("access_token");

    }

    public static String getToken(){
        //todo: 支持两种类型的token
        if(token==null){
            token=getWeworkToken(WeworkConfig.getInstance().contactSecret);
        }
        return token;
    }
}
