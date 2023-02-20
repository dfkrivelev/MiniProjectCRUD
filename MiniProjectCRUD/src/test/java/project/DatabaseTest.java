package project;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.xml.crypto.Data;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {

    @Test
    void createOne() {
    }

    @Test
    void createMany() {
        Employee employee = new Employee("Name", "LastName", "Position", 6500, 25);

        List<Employee> test = new ArrayList<>();
        test.add(employee);

        String input = "Name LastName Position 6500 25";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        new Database(DbInit.employees).createMany();

        Assertions.assertEquals(test, DbInit.employees);
    }

    @Test
    void read() {
    }

    @Test
    void find() {
    }

    @Test
    void update() {
    }

    @Test
    void findById() {
    }

    @Test
    void delete() {
    }

    @Test
    void sort() {
    }
}