package com.assignment.restfulAPI.part1;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Component
public class Employee_Dao_Service {
    private static List<Employee_Bean> emp= new ArrayList<>();
    private static int empCount = 4;

    static{
        emp.add(new Employee_Bean(1,23,"Riya"));
        emp.add(new Employee_Bean(2,21,"Paras"));
        emp.add(new Employee_Bean(3,22,"Avi"));
        emp.add(new Employee_Bean(4,20,"Ritik"));
    }
    public Employee_Bean save(Employee_Bean employee) {
        employee.setId(++empCount);
        emp.add(employee);
        return employee;
    }
    public List<Employee_Bean> findAll(){
        return emp;
    }

    public Employee_Bean findOne(int id) {
        Predicate<Employee_Bean> predicate = Emp -> Emp.getId()==(id);
        Optional<Employee_Bean> employee = emp.stream().filter(predicate).findFirst();
        return employee.orElse(null);// Avoids NoSuchElementException
    }

    public void deleteById(int id) {
        Predicate<? super Employee_Bean> predicate = Emp -> Emp.getId()==(id);
        emp.removeIf(predicate);
    }

    public Employee_Bean updateEmployee(int id, Employee_Bean updatedEmployee) {
        for (Employee_Bean employee : emp) {
            if (employee.getId() == id) {
                employee.setName(updatedEmployee.getName());
                employee.setAge(updatedEmployee.getAge());
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
    }

}

