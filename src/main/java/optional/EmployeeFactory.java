package optional;

import java.util.ArrayList;
import java.util.List;

import common.Employee;

public class EmployeeFactory {
	private List<Employee> employees = new ArrayList<>();
	public EmployeeFactory() {
        employees.add(new Employee("Alice", 22));
        employees.add(new Employee("Bob", 9));
        employees.add(new Employee("Charlie", 17));
        employees.add(new Employee("David", 15));
        employees.add(new Employee("Even", 35));
	}
    /**
     * 課題用の社員リストを作る
     * @return 社員リスト
     */
    public List<Employee> getEmployeeList() {
        return employees;
    }

    /**
     * 社員情報をDBから取る(仮）
     * @param name 社員の名前
     * @return 社員インスタンス
     */
    public Employee query(String name) {
        return query(name, 1);
    }

    /**
     * 社員情報をDBから取る(仮）
     * @param name 社員の名前
     * @param age 年齢
     * @return 社員インスタンス
     */
    public Employee query(String name, int age) {
        return new Employee(name, age);
    }
}
