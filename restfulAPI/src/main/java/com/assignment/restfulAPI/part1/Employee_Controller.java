package com.assignment.restfulAPI.part1;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/employees")
public class Employee_Controller<get> {
    @Autowired
    private Employee_Dao_Service employeeDaoService;

    private Employee_Controller(Employee_Dao_Service employeeDaoService){
        this.employeeDaoService=employeeDaoService;
    }

    @GetMapping("/details")
    public List<Employee_Bean> retrieveAll(){
        return employeeDaoService.findAll();
    }

    @GetMapping("/details/{id}")
    public Employee_Bean retrieveUser(@PathVariable int id) {
        Employee_Bean employee = employeeDaoService.findOne(id);
        if (employee == null) {
            throw  new EmployeeNotFoundException("id"+id);
        }
        return employee;
    }

    @PostMapping("/add")
    public void createUser(@RequestBody Employee_Bean employee) {
        employeeDaoService.save(employee);
    }
    @PostMapping("/emp")
    public ResponseEntity<Employee_Bean> createUserWithValidation(@Valid @RequestBody Employee_Bean employee) {
        Employee_Bean savedUser = employeeDaoService.save(employee);
        return ResponseEntity.created(null).build();
    }

    @PostMapping("/add/httpcode")
    public ResponseEntity<Employee_Bean> createUserWithHttpCode(@RequestBody Employee_Bean employee) {

        Employee_Bean savedUser = employeeDaoService.save(employee);
        return ResponseEntity.created(null).build();
    }

    @PostMapping("/add/httpcode/createdemp")
    public ResponseEntity<Employee_Bean> createUserWithHttpCodeCreatedEmp(@RequestBody Employee_Bean employee) {

        Employee_Bean savedUser = employeeDaoService.save(employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable int id) {
        employeeDaoService.deleteById(id);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee_Bean> updateEmployee(
            @PathVariable int id,
            @RequestBody Employee_Bean updatedEmployee) {

        Employee_Bean employee = employeeDaoService.updateEmployee(id, updatedEmployee);
        return ResponseEntity.ok(employee);
    }

}
