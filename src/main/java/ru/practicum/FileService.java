package ru.practicum;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService implements FileServiceInterface {
    @Override
    public void saveEmployeesToFile(List<Employee> employees, String filename) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                for (Employee e : employees) {
                    writer.write(e.getId() + "," + e.getFirstName() + "," + e.getLastName() + "," + e.getSalary());
                    writer.newLine();
                }
            } catch (IOException exp) {
                exp.printStackTrace();
            }
    }

    @Override
    public List<Employee> loadEmployeesFromFile(String filename) throws FileLoadException {
        List<Employee> employees = new ArrayList<>();
        File file = new File(filename);
        if (!file.exists()) {
            throw new FileLoadException("Файл не найден: " + filename);
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                String[] parts = line.split(",");
                if (parts.length != 4) {
                    System.err.println("Ошибка формата в строке " + lineNumber + ": " + line);
                    continue;
                }
                try {
                    Employee emp = new Employee();
                    emp.setId(Integer.parseInt(parts[0].trim()));
                    emp.setFirstName(parts[1].trim());
                    emp.setLastName(parts[2].trim());
                    emp.setSalary(Integer.parseInt(parts[3].trim()));

                    employees.add(emp);
                } catch (NumberFormatException ex) {
                    System.err.println("Ошибка преобразования числа в строке " + lineNumber + ": " + line);
                }
            }
        } catch (IOException e) {
            throw new FileLoadException("Ошибка чтения файла: " + e.getMessage());
        }
        return employees;
    }
}
