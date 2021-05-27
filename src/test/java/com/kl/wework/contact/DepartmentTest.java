package com.kl.wework.contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {
    Department department;

    @BeforeEach
    void setUp() {
        if(department == null) {
            department = new Department();
        }

    }

    @Test
    void list() {
        Department department = new Department();
        department.list("").then().statusCode(200)
        .body("department.name[2]",equalTo("kl研发中"));
    }

    @Test
    void create() {
        department.create("dep2","1");
    }

    @Test
    void delete() {
        Department department = new Department();
        department.delete("6").then().statusCode(200);

    }
}