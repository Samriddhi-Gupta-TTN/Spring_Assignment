package com.spring.assignment.datajpa.part2.Question1and2;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmpRepo1 extends CrudRepository<Emp, Integer> {

    @Query("Select e.firstName, e.lastName from Emp e where e.salary > (select AVG(e.salary) from Emp e) order by e.age asc, e.salary desc")
    List<Object[]> findEmployeesWithSalaryGreaterThanAverage();

    @Modifying
    @Transactional
    @Query(value = "UPDATE employee_table e1 "
            + "JOIN (SELECT AVG(e2.emp_salary) AS avgSalary FROM employee_table e2) AS temp "
            + "ON e1.emp_salary < temp.avgSalary "
            + "SET e1.emp_salary = :newSalary",
            nativeQuery = true)
    int updateSalaryForEmployeesBelowAverage(@Param("newSalary") double newSalary);

    @Query("select min(e.salary) from Emp e")
    Double findMinSalary();

    @Modifying
    @Transactional
    @Query("delete from Emp e where e.salary =: minSalary")
    void deleteEmployeesWithMinSalary(@Param("minSalary") Double minSalary);

    @Query(value = "SELECT id, emp_first_name, emp_age FROM employee_table WHERE emp_last_name LIKE '%Singh'", nativeQuery = true)
    List<Object[]> findEmployeesWithLastNameSingh();

    @Modifying
    @Transactional
    @Query("delete from Emp e where e.age > :age")
    int deleteEmployeeOlderThan(@Param("age") int age);

}
