package com.spring.assignment.datajpa.part2.Question4;
import jakarta.persistence.*;
@Entity
@Table(name = "employee")
public class Employee3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private int age;

    @Embedded
    private SalaryDetails2 salaryDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public SalaryDetails2 getSalaryDetails() {
        return salaryDetails;
    }

    public void setSalaryDetails(SalaryDetails2 salaryDetails) {
        this.salaryDetails = salaryDetails;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}