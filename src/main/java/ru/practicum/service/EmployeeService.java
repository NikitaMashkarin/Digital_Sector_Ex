package ru.practicum.service;

import ru.practicum.exception.EmployeeNotFoundException;
import ru.practicum.model.Employee;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeService implements EmployeeServiceInterface {
    @Override
    public Employee getEmployeeById(int id, List<Employee> employees) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Сотрудник не найден"));
    }

    @Override
    public List<Employee> getEmployeesBySalaryGreaterThan(int targetSalary, List<Employee> employees) {
        return employees.stream()
                .filter(e -> e.getSalary() >= targetSalary)
                .toList();
    }

    @Override
    public Map<String, Employee> getEmployeeMap(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.toMap(e -> "id" + e.getId(), e -> e));
    }
}
