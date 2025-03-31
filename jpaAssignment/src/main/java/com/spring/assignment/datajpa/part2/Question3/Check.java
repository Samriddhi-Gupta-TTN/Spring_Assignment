package com.spring.assignment.datajpa.part2.Question3;
import jakarta.persistence.*;

//@DiscriminatorValue("ch")
@Table(name="bank_check")
//@PrimaryKeyJoinColumn(name = "id")
@Entity
public class Check extends Payment {
    @Column(name = "check_number")
    private String checkNumber;

    public Check() {
    }

    public String getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(String checkNumber) {
        this.checkNumber = checkNumber;
    }
}