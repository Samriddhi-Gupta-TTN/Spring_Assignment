package com.assignment.restfulAPI.part2.Question6;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UserHateoasService {

    private final List<UsersHateoas> users = Arrays.asList(
            new UsersHateoas(1, "Samriddhi Gupta", "samriddhi.gupta@google.com"),
            new UsersHateoas(2, "Paras Singhal", "paras.singhal@google.com"),
            new UsersHateoas(3, "Parul Arora", "parul.arora@google.com"),
            new UsersHateoas(4, "Riya Jha", "riya.jha@google.com")
    );

    public UsersHateoas getUserById(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<UsersHateoas> getAllUsers() {
        return users;
    }
}