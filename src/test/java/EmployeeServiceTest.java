import org.junit.jupiter.api.Test;
import ru.practicum.*;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceTest {
    private final EmployeeServiceInterface employeeService = new EmployeeService();

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
    void testGetEmployeeById() {
        Employee e = employeeService.getEmployeeById(1, employees);
        assertEquals("Иван", e.getFirstName());
        assertEquals("Петров", e.getLastName());
        assertEquals(35000, e.getSalary());
    }

    @Test
    void testGetEmployeesBySalaryGreaterThan() {
        List<Employee> employeeList = employeeService.getEmployeesBySalaryGreaterThan(0, employees);
        assertEquals(employeeList.size(), 7);
        employeeList = employeeService.getEmployeesBySalaryGreaterThan(100000, employees);
        assertEquals(employeeList.size(), 0);
        employeeList = employeeService.getEmployeesBySalaryGreaterThan(60000, employees);
        assertEquals(employeeList.size(), 1);
        assertEquals(employeeList.getLast(), employees.get(3));
    }

    @Test
    void testGetEmployeeMap() {
        Map<String, Employee> map = employeeService.getEmployeeMap(employees);
        assertEquals(7, map.size());

        for (Employee e : employees) {
            String key = "id" + e.getId();
            assertTrue(map.containsKey(key));
            assertEquals(e, map.get(key));
        }
    }

}
