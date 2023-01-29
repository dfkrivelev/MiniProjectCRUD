package project;

import java.util.*;

public class Database {
    List<Employee> employeeList;
    Map<Integer, Employee> indexMap;

    public Database(List<Employee> employeeList) {
        //create list
        this.employeeList = new ArrayList<>();
        this.employeeList.addAll(employeeList);
        //create map (index)
        this.indexMap = new HashMap<>();
        for (Employee employee : employeeList) {
            indexMap.put(employee.getId(), employee);
        }
    }

    public void create() {
        Employee employee = DataUtil.getEmployee("create: ");
        if (employee != null) {
            employeeList.add(employee);
            indexMap.put(employee.getId(), employee);
            System.out.println("Added " + employee);
        }
    }

    public void read() {
        DataUtil.print(employeeList);
    }

    public void find() {
        String name = DataUtil.getString("find: ");
        List<Employee> found = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getName().contains(name)) {
                found.add(employee);
            }
        }
        DataUtil.print(found);
    }

    private Employee findById(int id) {
        return indexMap.get(id);
    }

    public void update() {
        int id = DataUtil.getInt("update, find by id: ");
        Employee employee = findById(id);
        if (employee != null) {
            Employee tmp = DataUtil.getEmployeePart("update (position, salary, age): ");
            if (tmp != null) {
                employee.update(tmp.getPosition(), tmp.getSalary(), tmp.getAge());
                System.out.println("Updated " + employee);
            }
        }
    }

    public void delete() {
        int id = DataUtil.getInt("remove, find by id: ");
        Employee employee = findById(id);
        if (employee != null) {
            employeeList.remove(employee);
            indexMap.remove(employee.getId());
            System.out.println("Deleted: " + employee);
        }
    }

    public void positions() {
        List<Position> positions = new ArrayList<>();
        for (Employee employee : employeeList) {
            positions.add(employee.getPosition());
        }
        System.out.println(new HashSet<>(positions));
    }

    public void sort() {
        String sortName = DataUtil.getString("sort: n[ame], p[osition], s[alary], a[ge]");
        Comparator<Employee> comparator = null;
        switch (sortName.toLowerCase().charAt(0)) {
            case 'n':
                comparator = new ComparatorName();
                break;
            case 'p':
                comparator = (o1, o2) -> o1.getPosition().toString().compareTo(o2.getPosition().toString());
                break;
            case 's':
                comparator = (o1, o2) -> o1.getSalary() - o2.getSalary();
                break;
            case 'a':
                comparator = (o1, o2) -> o1.getAge() - o2.getAge();
                break;
            default:
                return;
        }
        List<Employee> sortList = new ArrayList<>(employeeList);
        sortList.sort(comparator);
        DataUtil.print(sortList);
    }
}
