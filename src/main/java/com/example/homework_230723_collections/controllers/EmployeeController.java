package com.example.homework_230723_collections.controllers;

import com.example.homework_230723_collections.Employee;
import com.example.homework_230723_collections.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<Collection<Employee>> getAllEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/employee")
    public ResponseEntity<Employee> getEmployee(@RequestParam String fio){
        return new ResponseEntity<>(employeeService.getEmployee(fio), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<Employee> deleteEmployee(@RequestParam String fio){
        return new ResponseEntity<>(employeeService.deleteEmployee(fio), HttpStatus.OK);
    }
}
