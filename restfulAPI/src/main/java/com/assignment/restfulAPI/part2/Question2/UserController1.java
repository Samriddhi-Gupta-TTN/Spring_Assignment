package com.assignment.restfulAPI.part2.Question2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController1 {

    private static List<User1> users = new ArrayList<>();

    static {
        users.add(new User1(1,"Sam","sam@gmail.com"));
        users.add(new User1(2,"Riya","riya@gmail.com"));
        users.add(new User1(3,"Avi","avi@gmail.com"));

    }

    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
    public List<User1> createUser(@RequestBody User1 user){
        user.setId(users.size() + 1);
        users.add(user);
        return users;
    }

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_XML_VALUE)
    public List<User1> getAllUsers(){
        return users;
    }
}