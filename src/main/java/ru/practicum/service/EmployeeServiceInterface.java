package ru.practicum.service;

import ru.practicum.model.Employee;
import ru.practicum.exception.EmployeeNotFoundException;

import java.util.List;
import java.util.Map;

/**
 * Интерфейс для работы со списком сотрудников.
 * Этот интерфейс определяет методы для получения сотрудника по идентификатору,
 * получения списка сотрудников с зарплатой выше заданного значения
 * и преобразования списка сотрудников в Map с ключом "id" + идентификатор сотрудника.
 */
public interface EmployeeServiceInterface {

    /**
     * Возвращает сотрудника по заданному идентификатору.
     * @param id идентификатор сотрудника
     * @param employees список сотрудников
     * @return объект Employee с соответствующим id
     * @throws EmployeeNotFoundException если сотрудник с таким id не найден
     */
    Employee getEmployeeById(int id, List<Employee> employees);

    /**
     * Возвращает список сотрудников, у которых зарплата больше или равна целевому значению.
     * @param targetSalary минимальная зарплата
     * @param employees список сотрудников
     * @return список сотрудников с зарплатой ≥ targetSalary
     */
    List<Employee> getEmployeesBySalaryGreaterThan(int targetSalary, List<Employee> employees);

    /**
     * Преобразует список сотрудников в Map, где ключ — строка "id" + id сотрудника, а значение — объект Employee.
     * @param employees список сотрудников
     * @return Map с ключами в формате "id{номер}" и значениями Employee
     */
    Map<String, Employee> getEmployeeMap(List<Employee> employees);
}
