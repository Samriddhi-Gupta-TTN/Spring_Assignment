package com.spring.assignment.datajpa.part3.Question8;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Book3 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(mappedBy = "book3")
    private List<Author3> authors;

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

    public List<Author3> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author3> authors) {
        this.authors = authors;
    }
}