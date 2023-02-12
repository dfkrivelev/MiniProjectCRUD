package project;

import java.io.*;
import java.util.*;

public class Database {
    List<Employee> employeeList;
    Map<Integer, Employee> indexMap;
    String path = "D:\\Dima\\JavaProject\\CRUD.txt";
    Scanner scanner = new Scanner(System.in);

    public Database(List<Employee> employeeList) {
        //create list
        this.employeeList = new ArrayList<>();
        this.employeeList.addAll(employeeList);
        //create map (index)
        this.indexMap = new HashMap<>();
        for (Employee employee : DbInit.employees) {
            indexMap.put(employee.getId(), employee);
        }
    }

    public void create() {
        Employee employee;
        String createName = DataUtil.getString("create: createOne, createMany");
        switch (createName.toLowerCase()) {
            case "createone":

                employee = DataUtil.getEmployee("create: ");
                DbInit.employees.add(employee);
                break;
            case "createmany":
                System.out.println("createMany: ");
                String list = scanner.nextLine();

                String[] parts = list.split(", ");
                List<Employee> employeeList = new ArrayList<>();

                for (int i = 0; i < parts.length; i++) {
                    String[] objects = parts[i].split(" ");
                    String firstName = objects[0];
                    String lastName = objects[1];
                    String position = objects[2];
                    int age = Integer.parseInt(objects[3]);
                    int salary = Integer.parseInt(objects[4]);

                    employee = new Employee(firstName, lastName, position, age, salary);
                    DbInit.employees.add(employee);
                }

                if (list.endsWith(",")) {
                    System.out.println("Неправильно введены данные" + list);
                } else {
                    String[] object = list.substring(list.lastIndexOf(", ") + 2).split(" ");
                    String firstName = object[0];
                    String lastName = object[1];
                    String position = object[2];
                    int age = Integer.parseInt(object[3]);
                    int salary = Integer.parseInt(object[4]);
                    employee = new Employee(firstName, lastName, position, age, salary);
                    employeeList.add(employee);
                    break;
                }
        }
    }

    public void read() {
        DataUtil.print(DbInit.employees);
    }

    public void find() {
        String str = DataUtil.getString("find: id, name, lastName, position, " +
                "age, salary");
        List<Employee> found = new ArrayList<>();
        switch (str.toLowerCase()) {
            case "id":
                int id = DataUtil.getInt("id: ");
                found.add(findById(id));
                DataUtil.print(found);
                break;
            case "name":
                String name = DataUtil.getString("name: ");
                for (Employee employee : DbInit.employees) {
                    if (employee.getName().contains(name)) {
                        found.add(employee);
                    }
                }
                DataUtil.print(found);
                break;
            case "lastname":
                String lastName = DataUtil.getString("lastName: ");
                for (Employee employee : DbInit.employees) {
                    if (employee.getLastName().contains(lastName)) {
                        found.add(employee);
                    }
                }
                DataUtil.print(found);
                break;
            case "position":
                String position = DataUtil.getString("position: ");
                for (Employee employee : DbInit.employees) {
                    if (employee.getPosition().contains(position)) {
                        found.add(employee);
                    }
                }
                DataUtil.print(found);
                break;
            case "age":
                int age = DataUtil.getInt("age: ");
                for (Employee employee : DbInit.employees) {
                    if (employee.getAge() == age) {
                        found.add(employee);
                    }
                }
                DataUtil.print(found);
                break;
            case "salary":
                int salary = DataUtil.getInt("salary: ");
                for (Employee employee : DbInit.employees) {
                    if (employee.getSalary() == salary) {
                        found.add(employee);
                    }
                }
                DataUtil.print(found);
                break;
            default:
                System.out.println("не ма такова");
        }
    }

    public void update() {
        int id = DataUtil.getInt("Изменить элемент под номером: ");
        if (findById(id) != null) {
            String tmp = DataUtil.getString("Изменить: name, lastName, position, age, salary");
            switch (tmp.toLowerCase()) {
                case "name":
                    System.out.println("New name: ");
                    findById(id).setName(scanner.next());
                    System.out.println(findById(id).toString());
                    break;
                case "lastname":
                    System.out.println("New lastname: ");
                    findById(id).setLastName(scanner.next());
                    System.out.println(findById(id).toString());
                    break;
                case "position":
                    System.out.println("New position: ");
                    findById(id).setPosition(scanner.next());
                    System.out.println(findById(id).toString());
                    break;
                case "age":
                    System.out.println("New age: ");
                    findById(id).setAge(scanner.nextInt());
                    System.out.println(findById(id).toString());
                    break;
                case "salary":
                    System.out.println("New salary: ");
                    findById(id).setSalary(scanner.nextInt());
                    System.out.println(findById(id).toString());
                    break;
            }
        }
    }

    public Employee findById(int id) {
        for (Employee employee : DbInit.employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        System.out.println("Нет такого id");
        return null;
    }

    public void delete() {
        int id = DataUtil.getInt("remove, find by id: ");
        Employee employee = findById(id);
        if (employee != null) {
            DbInit.employees.remove(employee);
            System.out.println("Deleted: " + employee);
        }
    }

    public void sort() {
        String sortName = DataUtil.getString("sort: n[ame], p[osition], s[alary], a[ge]");
        Comparator<Employee> comparator = null;
        switch (sortName.toLowerCase()) {
            case "name":
                comparator = Comparator.comparing(Employee::getName);
                break;
            case "lastname":
                comparator = Comparator.comparing(Employee::getLastName);
                break;
            case "position":
                comparator = Comparator.comparing(Employee::getPosition);
                break;
            case "salary":
                comparator = Comparator.comparingInt(Employee::getSalary);
                break;
            case "age":
                comparator = Comparator.comparingInt(Employee::getAge);
                break;
            default:
                return;
        }
        List<Employee> sortList = new ArrayList<>(DbInit.employees);
        sortList.sort(comparator);
        DataUtil.print(sortList);
    }

    public void save() {
        try (FileOutputStream fileOutputStream = new FileOutputStream(path);
             ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream)) {
            outputStream.writeObject(DbInit.employees);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void load() {
        try (FileInputStream fileInputStream = new FileInputStream(path);
             ObjectInputStream inputStream = new ObjectInputStream(fileInputStream)) {
            DbInit.load = (ArrayList<Employee>) inputStream.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        DbInit.employees = DbInit.load;
    }
}