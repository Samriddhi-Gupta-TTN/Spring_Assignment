package com.spring.assignment.datajpa.part1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService service;
    //    answer3
    @PostMapping("/create")
    public ResponseEntity<EmployeeEntity> createEmployee(@RequestBody EmployeeEntity employee){
        return service.createEmployee(employee);
    }

    //  answer4
    @PutMapping("/update/{id}")
    public ResponseEntity<EmployeeEntity> updateEmployee(@RequestBody EmployeeEntity employee, @PathVariable Integer id){
        return service.updateEmployee(employee, id);
    }

    //  answer5
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String > deleteEmployee(@PathVariable Integer id){
        return service.deleteEmployee(id);
    }

    //  answer6
    @GetMapping("/get")
    public ResponseEntity<List<EmployeeEntity>> getEmployees(){
        return service.getEmployees();
    }

    //  answer7
    @GetMapping("/count")
    public ResponseEntity<Long> getEmployeeCount(){
        return service.getCount();
    }

    //  answer8
    @GetMapping("/all")
    public ResponseEntity<List<EmployeeEntity>> getEmployeesPagingAndSorting(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size,
            @RequestParam(defaultValue = "asc") String sort
    ){
        return service.getEmployeesPagingAndSorting(page, size, sort);
    }

    //  answer9
    @GetMapping("/findByName/{name}")
    public List<EmployeeEntity> findByName(@PathVariable String name){
        return service.findByName(name);
    }

    //  answer10
    @GetMapping("/startingWithA/{var}")
    public List<EmployeeEntity> statingWithA(@PathVariable String var){
        return service.findByNameStartingWithA(var);
    }

    //  answer11
    @GetMapping("/ageBetween/{a}/{b}")
    public List<EmployeeEntity> ageBetween(@PathVariable int a,@PathVariable int b){
        return service.ageBetween(a,b);
    }

}