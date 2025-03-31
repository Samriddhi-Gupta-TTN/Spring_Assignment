package com.spring.assignment.datajpa.part2.Question3;

import jakarta.persistence.*;

//@DiscriminatorValue("cc")
@Table(name = "card")
//@PrimaryKeyJoinColumn(name = "id")
@Entity
public class CreditCard extends Payment {
    @Column(name = "card_number")
    private String cardNumber;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}