package ru.practicum.service;

import ru.practicum.model.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeServiceInterface {
    //Метод находит сотрудника по его ID
    //В аргументы передаются id сотрудника(int) и список сотрудников(List<Employee>)
    //Метод возвращает найденного сотрудника(Employee)
    Employee getEmployeeById(int id, List<Employee> employees);

    //Метод находит сотрудников, чья зарплата больше или равна переданной
    //В аргументы передаются зарплата(int) и список сотрудников(List<Employee>)
    //Метод возвращает список сотрудников(List<Employee>), чья зарплата больше или равна переданной
    List<Employee> getEmployeesBySalaryGreaterThan(int targetSalary, List<Employee> employees);

    //Метод преобразует список сотрудников в HashMap, где ключ строка "id+" + id
    //В аргументы передается список сотрудников(List<Employee>)
    //Метод возвращает HashMap<String, Employee>
    Map<String, Employee> getEmployeeMap(List<Employee> employees);
}
