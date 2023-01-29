package project;

import java.util.Arrays;
import java.util.List;

public class DbInit {
    public static List<Employee> init() {
        List<Employee> employees = Arrays.asList(
                new Employee("Big", Position.BOSS, 5000, 45),
                new Employee("Gina", Position.ASSISTANT, 1500, 21),
                new Employee("Bill", Position.ENGINEER, 1300, 35),
                new Employee("john", Position.ENGINEER, 1550, 27),
                new Employee("mike", Position.ENGINEER, 1700, 42),
                new Employee("john", Position.ENGINEER, 900, 19)
        );
        return employees;
    }
}
