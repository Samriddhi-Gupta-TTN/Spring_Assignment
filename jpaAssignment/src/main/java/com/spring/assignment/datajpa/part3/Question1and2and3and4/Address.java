package com.spring.assignment.datajpa.part3.Question1and2and3and4;

import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private int streetNumber;
    private String location;
    private String state;
}