package day9;

import day6.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeFactory {
    public static List<Employee> getEmployeeList() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 22));
        employees.add(new Employee("Bob", 9));
        employees.add(new Employee("Charlie", 17));
        employees.add(new Employee("David", 15));
        employees.add(new Employee("Even", 13));
        return employees;
    }
}
