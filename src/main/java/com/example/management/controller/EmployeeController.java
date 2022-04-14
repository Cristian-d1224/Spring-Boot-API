package com.example.management.controller;


import com.example.management.model.Employee;
import com.example.management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    @PostMapping("/saveEmployee")
    public String saveEmployee(@RequestBody Employee employee){
        repository.save(employee);
        return "Employee saved..";
    }

    @GetMapping("/getAllEmployees")
    public List<Employee> getAll(){
        return repository.findAll();
    }

    @GetMapping("/getEmployee/{department}")
    public List<Employee> getEmployeesByDept(@PathVariable String department){
        return repository.findByDept(department);
    }
}
