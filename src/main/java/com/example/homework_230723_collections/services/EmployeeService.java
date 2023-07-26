package com.example.homework_230723_collections.services;

import com.example.homework_230723_collections.Employee;

import java.util.Collection;

public interface EmployeeService {
    Collection<Employee> getAllEmployees();
    Employee getEmployee(String key);
    Employee deleteEmployee(String key);
    Employee addEmployee(Employee employee);
}
