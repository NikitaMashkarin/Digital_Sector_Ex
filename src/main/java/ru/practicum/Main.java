package ru.practicum;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        EmployeeServiceInterface employeeService = new EmployeeService();
        FileServiceInterface fileService = new FileService();

        List<Employee> employees = List.of(new Employee(1, "Иван", "Петров", 35000),
                new Employee(2, "Анна", "Сидорова", 52000),
                new Employee(3, "Дмитрий", "Кузнецов", 41000),
                new Employee(4, "Екатерина", "Иванова", 60000),
                new Employee(5, "Алексей", "Смирнов", 47000),
                new Employee(6, "Мария", "Орлова", 55000),
                new Employee(7, "Сергей", "Васильев", 38000));

        System.out.println("Поиск сотрудника по id = 1:" + employeeService.getEmployeeById(1, employees));

        System.out.println("Поиск сотрудников с зарплатой равной или более 41000:");
        for (Employee e: employeeService.getEmployeesBySalaryGreaterThan(41000, employees))
            System.out.println(e);

        System.out.println("Преобразование списка в map");
        Map<String, Employee> employeeMap = employeeService.getEmployeeMap(employees);
        for(String str : employeeMap.keySet())
            System.out.println(str + " " + employeeMap.get(str));

        System.out.println("Выгрузка списка в файл");
        fileService.saveEmployeesToFile(employees, "employeesFile");

        System.out.println("Выгрузка списка из файл");
        for(Employee e : fileService.loadEmployeesFromFile("employeesFile"))
            System.out.println(e);
    }
}