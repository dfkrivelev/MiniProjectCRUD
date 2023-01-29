package project;

import java.util.Comparator;

public class ComparatorPosition implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getPosition().toString().compareTo(o2.getPosition().toString());
    }
}
