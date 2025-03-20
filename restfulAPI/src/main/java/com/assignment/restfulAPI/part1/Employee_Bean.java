package com.assignment.restfulAPI.part1;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Employee_Bean {
    private int id;
    private int age;
    @NotNull
    @Size(min=2, message = "Name should have atleast 2 characters")
    private String name;

    public Employee_Bean(int id, int age, String name) {
        this.id=id;
        this.age=age;
        this.name=name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee_Bean{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
