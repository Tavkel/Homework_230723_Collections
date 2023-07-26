package com.example.homework_230723_collections.services.implementations;

import com.example.homework_230723_collections.Employee;
import com.example.homework_230723_collections.EmployeeAlreadyExistsException;
import com.example.homework_230723_collections.EmployeeBook;
import com.example.homework_230723_collections.EmployeeNotFoundException;
import com.example.homework_230723_collections.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeBook employees;
    public EmployeeServiceImpl(EmployeeBook employeeBook) {
        this.employees = employeeBook;
    }

    @Override
    public Collection<Employee> getAllEmployees() {
        return this.employees.getEmployeeBook().values();
    }

    @Override
    public Employee getEmployee(String key) {
        if(employees.getEmployeeBook().containsKey(key)){
            return employees.getEmployeeBook().get(key);
        } else{
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee deleteEmployee(String key) {
        if(employees.getEmployeeBook().containsKey(key)){
            var result =  employees.getEmployeeBook().get(key);
            employees.getEmployeeBook().remove(key);
            return result;
        } else{
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee addEmployee(Employee employee) {
        String key = employee.getFirstName() + employee.getLastName();
        if(!employees.getEmployeeBook().containsKey(key)){
            employees.getEmployeeBook().put(key, employee);
            return employee;
        } else{
            throw new EmployeeAlreadyExistsException();
        }
    }
}
