package ru.practicum.service;

import ru.practicum.exception.FileLoadException;
import ru.practicum.model.Employee;

import java.util.List;

/**
 * Интерфейс для работы с файлами сотрудников.
 * Этот интерфейс определяет методы для сохранения списка сотрудников в файл
 * и загрузки списка сотрудников из файла.
 */
public interface FileServiceInterface {

    /**
     * Сохраняет список сотрудников в файл.
     * Каждый сотрудник записывается в отдельной строке в формате: id,firstName,lastName,salary
     * @param employees список сотрудников
     * @param filename  имя файла, в который будут записаны данные
     */
    void saveEmployeesToFile(List<Employee> employees, String filename);

    /**
     * Загружает список сотрудников из указанного файла.
     * Ожидаемый формат файла: каждая строка содержит данные сотрудника в формате: id,firstName,lastName,salary
     * @param filename имя файла для чтения
     * @return список сотрудников, загруженных из файла
     * @throws FileLoadException если файл не найден или произошла ошибка чтения
     */
    List<Employee> loadEmployeesFromFile(String filename) throws FileLoadException;
}
