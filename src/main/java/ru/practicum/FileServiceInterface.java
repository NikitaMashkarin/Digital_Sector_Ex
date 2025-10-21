package ru.practicum;

import java.util.List;

public interface FileServiceInterface {
    //Метод сохраняет список сотрудников в текстовый файл
    //В аргументы передается список сотрудников(List<Employee>) и название файла String
    void saveEmployeesToFile(List<Employee> employees, String filename);

    //Метод читает данные о сотрудниках из файла
    //В аргументы передается название файла String
    //Метод возвращает список сотрудников из файла(List<Employee>)
    List<Employee> loadEmployeesFromFile(String filename);
}
