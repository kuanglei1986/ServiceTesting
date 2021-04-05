package com.learn;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class Test_GetUserMoneyInfo {
    public static void main(String[] args) {
        String url = "http://zuowen.api.juhe.cn/zuowen/typeList";
        RequestConfig requestConfig =  new RequestConfig();
        requestConfig.setHttpURIandPortValue(url);

        //Map集合设置请求参数
        Map setParams = new HashMap();
        setParams.put("id", 1);
        setParams.put("key", "5f92e59c58cc99a949f51958e817e95f");

        Response res = requestConfig.setGet(setParams,url);
        res.prettyPrint();

    }

}
