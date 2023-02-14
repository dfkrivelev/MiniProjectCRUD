package project;

import java.util.List;
import java.util.Scanner;

public class DataUtil {
    private static Scanner scanner = new Scanner(System.in);

    public static void print(List<Employee> toPrint) {
        for (Employee employee : toPrint) {
            System.out.println(employee);
        }
    }

    public static String getString(String prompt) {
        System.out.println(prompt);
        String value = scanner.next();
        return value;
    }

    public static int getInt(String prompt) {
        System.out.println(prompt);
        int value = scanner.nextInt();
        return value;
    }

    public static Employee getEmployee(String prompt) {
        System.out.println(prompt);
        String name = scanner.next();
        String lastName = scanner.next();
        String position = scanner.next();
        int age = scanner.nextInt();
        int salary = scanner.nextInt();
        return new Employee(name, lastName, position, age, salary);
    }
}