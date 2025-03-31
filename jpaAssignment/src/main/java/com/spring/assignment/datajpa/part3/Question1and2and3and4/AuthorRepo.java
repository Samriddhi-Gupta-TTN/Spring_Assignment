package com.spring.assignment.datajpa.part3.Question1and2and3and4;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AuthorRepo extends CrudRepository<Author, Long> {

    List<Author> findAll();
}
