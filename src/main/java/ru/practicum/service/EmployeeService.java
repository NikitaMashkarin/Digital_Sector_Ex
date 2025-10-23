package ru.practicum.service;

import ru.practicum.exception.EmployeeNotFoundException;
import ru.practicum.model.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeService implements EmployeeServiceInterface {
    @Override
    public Employee getEmployeeById(int id, List<Employee> employees) {
        for (Employee e : employees)
            if (e.getId() == id) return e;
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    @Override
    public List<Employee> getEmployeesBySalaryGreaterThan(int targetSalary, List<Employee> employees) {
        return employees.stream()
                .filter(e -> e.getSalary() >= targetSalary)
                .toList();
    }

    @Override
    public Map<String, Employee> getEmployeeMap(List<Employee> employees) {
        Map<String, Employee> employeesMap = new HashMap<>();
        for (Employee e : employees)
            employeesMap.put("id" + e.getId(), e);
        return employeesMap;
    }
}
