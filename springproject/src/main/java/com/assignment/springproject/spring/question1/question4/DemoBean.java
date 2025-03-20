package com.assignment.springproject.spring.question1.question4;

import org.springframework.stereotype.Component;

@Component
public class DemoBean {
    private String name;
    private int id;

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}