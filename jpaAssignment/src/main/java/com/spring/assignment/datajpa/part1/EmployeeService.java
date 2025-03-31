package com.spring.assignment.datajpa.part1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo repository;
    public ResponseEntity<EmployeeEntity> createEmployee(EmployeeEntity employee) {
        return new ResponseEntity<EmployeeEntity>(repository.save(employee), HttpStatus.CREATED);
    }

    public ResponseEntity<EmployeeEntity> updateEmployee(EmployeeEntity employee, Integer id) {

        Optional<EmployeeEntity> oldEmployee = repository.findById(id);
        if(oldEmployee.isEmpty()){
            return new ResponseEntity<EmployeeEntity>(HttpStatus.NOT_FOUND);
        }
        oldEmployee.ifPresent(emp->{
            emp.setName(employee.getName() != null && !employee.getName().isEmpty() ? employee.getName() : emp.getName());
            emp.setAge(employee.getAge() != null ? employee.getAge() : emp.getAge());
            repository.save(emp);
        });
        return new ResponseEntity<>(oldEmployee.get(),HttpStatus.OK);

    }

    public ResponseEntity<String> deleteEmployee(Integer id) {

        if(repository.existsById(id)){
            repository.deleteById(id);
            return new ResponseEntity<>("Employee with id: "+id+" deleted successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("No employee found with this id",HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<List<EmployeeEntity>> getEmployees() {
        return new ResponseEntity<>(repository.findAll(),HttpStatus.OK);
    }

    public ResponseEntity<Long> getCount() {
        return new ResponseEntity<>(repository.count(),HttpStatus.OK);
    }


    public ResponseEntity<List<EmployeeEntity>> getEmployeesPagingAndSorting(int page, int size, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase("asc")
                ? Sort.by("age").ascending()
                : Sort.by("age").descending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<EmployeeEntity> employeePage = repository.findAll(pageable);

        return new ResponseEntity<>(employeePage.getContent(), HttpStatus.OK);
    }

    public List<EmployeeEntity> findByName(String name) {
        return repository.findByName(name);
    }

    public List<EmployeeEntity> findByNameStartingWithA(String var) {
        return repository.findByNameStartingWith(var);
    }

    public List<EmployeeEntity> ageBetween(int a, int b) {
        return repository.findByAgeBetween(a,b);
    }
}