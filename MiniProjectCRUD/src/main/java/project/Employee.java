package project;

import java.io.Serializable;

public class Employee implements Serializable {
    private int id;
    private String name;
    private String lastName;
    private String position;
    private int salary;
    private int age;
    private static int count;

    public Employee(String name, String lastName, String position, int age, int salary) {
        this.name = name;
        this.lastName = lastName;
        this.position = position;
        this.salary = salary;
        this.age = age;
        if(DbInit.employees.isEmpty()){
            count = 0;
        }else {
            count = DbInit.employees.get(DbInit.employees.size() - 1).getId();
        }
        this.id = ++count;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void update(String position, int salary, int age) {
        this.position = position;
        this.salary = salary;
        this.age = age;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }
}