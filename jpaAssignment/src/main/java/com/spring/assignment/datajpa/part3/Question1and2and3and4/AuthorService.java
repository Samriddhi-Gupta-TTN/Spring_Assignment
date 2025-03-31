package com.spring.assignment.datajpa.part3.Question1and2and3and4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorService {

    @Autowired
    private AuthorRepo authorRepository;

    public ResponseEntity<Author> saveAuthor(Author author){
        return new ResponseEntity<>(authorRepository.save(author), HttpStatus.CREATED);
    }

    public ResponseEntity<List<Author>> getAllAuthors(){
        List<Author> authors = authorRepository.findAll();
        return ResponseEntity.ok(authors);  // Use HttpStatus.OK instead of FOUND
    }

}