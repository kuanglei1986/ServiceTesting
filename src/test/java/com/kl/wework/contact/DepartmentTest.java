package com.kl.wework.contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {
    Department department;
    String random=String.valueOf(System.currentTimeMillis());

    @BeforeEach
    void setUp() {
        if(department == null) {
            department = new Department();
        }

    }

    @Test
    void list() {
        department.list("").then().statusCode(200)
        .body("department.name[1]",equalTo("广州研发中心"));
    }

    @Test
    void create() {
        department.create("kl_dep" + random, "1")
                .then().body("errcode",equalTo(0))
        ;

    }

    @Test
    void createByMap() {
        HashMap<String,Object> map = new HashMap<String,Object>() {
            {
                put("name", String.format("seveniruby_d1_map%s", random));
                put("parentid", "1");
            }
        };
        department.create(map)
                .then().body("errcode",equalTo(0))
        ;

    }

    @Test
    void delete() {
        String oldname = "test" + random;
        department.create(oldname,"1");
        Integer idInt = department.list("")
                .path("department.find{it.name == '"+oldname+"'}.id");
        String id = String.valueOf(idInt);
        department.delete(id).then().log().all().body("errcode",equalTo(0));

    }

    @Test
    void deleteAll() {
        department.deleteAll();
    }

    @Test
    void update() {
        String oldname = "test" + random;
        department.create(oldname,"1");
        Integer idInt = department.list("")
                .path("department.find{it.name == '"+oldname+"'}.id");
        String id = String.valueOf(idInt);
        department.update("test2",id).then().log().all().body("errcode",equalTo(0));


    }
}