package com.assignment.restfulAPI.part1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/Welcome")
    public String sayHello(){
        return "Welcome to spring boot";
    }
}
