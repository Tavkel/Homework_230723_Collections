package com.example.homework_230723_collections;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class EmployeeBook {
    private Map<String, Employee> employeeBook;

    public EmployeeBook() {
        this.employeeBook = new HashMap<String, Employee>();
        Employee[] arr = {new Employee("Vorontsova", "Maria", 60_000f, 1),
        new Employee("Zazu", "Petr", 65_000f, 2),
        new Employee("Letniy", "Boris", 95_000f, 1),
        new Employee("Elkina", "Irina", 75_000f, 1),
        new Employee("Pechkin", "Aleksey", 86_000f, 4),

        new Employee("Korobkina", "Liliya", 100_000f, 3),
        new Employee("Pogodin", "Lev", 77_000f, 5),
        new Employee("Pirogov", "Artem", 43_000f, 5),
        new Employee("Pushkina", "Aleksandra", 43_000f, 3),
        new Employee("Rukin", "Egor", 70_000f, 2)};

        for (var e : arr){
            this.employeeBook.put(e.getFirstName() + e.getLastName(), e);
        }
    }

    public Map<String, Employee> getEmployeeBook() {
        return employeeBook;
    }

}
