package com.kl.wework.contact;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void list() {
        Department department = new Department();
        department.list("").then().statusCode(200)
        .body("department.name[2]",equalTo("kl研发中"));
    }

    @Test
    void delete() {
        Department department = new Department();
        department.delete("6").then().statusCode(200);

    }
}