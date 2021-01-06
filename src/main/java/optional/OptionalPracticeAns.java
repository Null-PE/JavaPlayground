package optional;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import common.Employee;

public class OptionalPracticeAns implements IOptionalPractice {
    private EmployeeFactory fac;
    public OptionalPracticeAns() {
    	fac = new EmployeeFactory();
    }
    /**
     * 課題１　メソッドを完成する
     */
    @Override
	public Optional<Employee> findEmployee(String name) {
    	return Optional.of(fac.query(name));
    }

    /**
     * 課題２　findEmployee(String name) を使って、社員"Tom"の情報を取得する
       社員情報が存在すれば、employeesに追加する
       存在しない場合、NULL_EMP　をemployeesに追加する
     */
    @Override
	public List<Employee> addEmployee(String name) {
    	List<Employee> employees = fac.getEmployeeList();
    	employees.add(findEmployee(name).orElse(NULL_EMP));
    	return employees;
    }
    /**
     * 課題３　employees から、３５歳の社員情報を1つだけ取る
     * 存在しない場合は、name="" aga=1 のEmployeeを作成する
     */
    @Override
	public Employee loadOne35Employee() {
    	List<Employee> employees = fac.getEmployeeList();
    	return employees.stream()
    					.filter(e -> e.getAge() == 35)
    					.findAny()
    					.orElseGet(() -> new Employee("", 1));
    }
    /**
     * 課題４ employeesから、２０歳以上 一番若い社員情報（1人だけ）を取る、
     * 存在しない場合は　NoSuchElementException をthrowする
     */
    @Override
	public Employee loadUpper20Youngest() {
    	List<Employee> employees = fac.getEmployeeList();
    	return employees.stream()
						.filter(e -> e.getAge() >= 20)
						.min(Comparator.comparingInt(Employee::getAge)).orElseThrow(NoSuchElementException::new);
    }
}
