package com.example.streams.service;

import com.example.streams.entity.Employee;
import org.springframework.util.comparator.ComparableComparator;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CombineSortService {
    public List<Employee> sortEmployee(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed().thenComparing(Employee::getAge).thenComparing(Employee::getName))
                .toList();
    }

    public List<Employee> getTestArray() {
        Employee e1 = new Employee();
        e1.setSalary(10);
        e1.setAge(20);
        e1.setName("abcddddd");
        Employee e2 = new Employee();
        e2.setSalary(10);
        e2.setAge(20);
        e2.setName("abca");
        Employee e3 = new Employee();
        e3.setSalary(5);
        e3.setAge(20);
        e3.setName("zoi");
        Employee e4 = new Employee();
        e4.setSalary(120);
        e4.setAge(20);
        e4.setName("Dan");
        Employee e5 = new Employee();
        e5.setSalary(120);
        e5.setAge(18);
        e5.setName("Stiv");

        return Arrays.asList(e2, e1, e3, e4, e5);
    }
}
