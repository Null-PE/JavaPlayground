package day10;

import java.util.ArrayList;
import java.util.List;

import day6.Employee;

public class EmployeeFactory2 {

	/**
	 * 課題用の社員リストを作る
	 * @return 社員リスト
	 */
	private static List<Employee> getEmployeeList() {
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Alice", 22));
		employees.add(new Employee("Bob", 9));
		employees.add(new Employee("Charlie", 17));
		employees.add(new Employee("David", 15));
		employees.add(new Employee("Even", 35));
		return employees;
	}

	/**
	 * 社員情報をDBから取る(仮）
	 * @param name 社員の名前
	 * @return 社員インスタンス。存在しない場合はnullを返します
	 */
	public static Employee query(String name) {
		for (Employee employee : getEmployeeList()) {
			if (name.equals(employee.getName())) {
				return employee;
			}
		}
		return null;
	}
}
