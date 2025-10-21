import org.junit.jupiter.api.*;
import ru.practicum.Employee;
import ru.practicum.FileService;
import ru.practicum.FileServiceInterface;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileServiceTest {
    private final FileServiceInterface fileService = new FileService();

    private final List<Employee> employees = List.of(
            new Employee(1, "Иван", "Петров", 35000),
            new Employee(2, "Анна", "Сидорова", 52000),
            new Employee(3, "Дмитрий", "Кузнецов", 41000),
            new Employee(4, "Екатерина", "Иванова", 60000),
            new Employee(5, "Алексей", "Смирнов", 47000),
            new Employee(6, "Мария", "Орлова", 55000),
            new Employee(7, "Сергей", "Васильев", 38000)
    );

    @Test
    void testSaveAndLoadEmployees() throws Exception {
        String testFilename = "test_employees";
        fileService.saveEmployeesToFile(employees, testFilename);
        File file = new File(testFilename);
        assertTrue(file.exists());
        List<Employee> loaded = fileService.loadEmployeesFromFile(testFilename);
        assertEquals(employees.size(), loaded.size());
        for (int i = 0; i < employees.size(); i++) {
            assertEquals(employees.get(i), loaded.get(i));
        }
    }
}
