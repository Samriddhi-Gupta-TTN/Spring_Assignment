package com.spring.assignment.datajpa.part1;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepo extends CrudRepository<EmployeeEntity, Integer> {
    List<EmployeeEntity> findAll();
    Page<EmployeeEntity> findAll(Pageable pageable);
    List<EmployeeEntity> findByName(String name);
    List<EmployeeEntity> findByNameStartingWith(String var);
    List<EmployeeEntity> findByAgeBetween(int a, int b);
}
