import org.junit.jupiter.api.Test;
import ru.practicum.model.Employee;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest {
    @Test
    void employeeTest(){
        Employee employee1 = new Employee(1, "Иван", "Петров", 35000);
        Employee employee2 = new Employee(1, "Иван", "Петров", 35000);
        assertEquals(employee1, employee2);
    }
}
