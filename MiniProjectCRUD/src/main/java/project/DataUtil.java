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
        int salary = scanner.hasNextInt() ? scanner.nextInt() : 0;
        int age = scanner.hasNextInt() ? scanner.nextInt() : 0;
        if(salary == 0 || age == 0){
            System.out.println("Добавлено для исправления");
        }
        return new Employee(name, lastName, position, salary, age);
    }
}