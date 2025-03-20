package com.assignment.restfulAPI.part2.Question4;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserService2 {

    private List<Users> users = new ArrayList<>();

    public Users saveUsers(Users user) {
        users.add(user);
        return user;
    }

    public List<Users> getAllUsers() {
        return users;
    }
}
