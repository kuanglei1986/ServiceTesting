package com.kl.wework.contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.equalTo;

class MemberTest {

    static Member member;
    @BeforeEach
    void setUp() {
        member=new Member();
    }

    @ParameterizedTest
    @ValueSource(strings = { "sevenriby_", "hogwarts_", "testerhome_"})
    void create(String name) {
        String nameNew="name"+member.random;
        String random=String.valueOf(System.currentTimeMillis()).substring(5+0, 5+8);
        HashMap<String,Object> map = new HashMap<>();
        map.put("userid", nameNew);
        map.put("name", nameNew);
        map.put("department", Arrays.asList(1, 2));
        map.put("mobile", "151"+ random);
        map.put("userid", nameNew);
        map.put("email", random + "@qq.com");
        System.out.println("start-------------");
        member.create(map).then().statusCode(200).body("errcode", equalTo(0));

    }
}