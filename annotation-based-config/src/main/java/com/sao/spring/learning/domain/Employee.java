package com.sao.spring.learning.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by saoprb on 3/12/17.
 */
@Component
public class Employee {

    private String name;

    @Autowired
    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
