package optional;

import java.util.List;
import java.util.Optional;

import common.Employee;

public class OptionalPractice implements IOptionalPractice{
    private EmployeeFactory fac;
    public OptionalPractice() {
    	fac = new EmployeeFactory();
    }
    /**
     * 課題１　コメントアウトの部分を修正して `return null;` と置き換えてください。
     */
    public Optional<Employee> findEmployee(String name) {
    	// TODO: return fac.query(name);
    	return null;
    }

    /**
     * 課題２　findEmployee(String name) を使って、社員"Tom"の情報を取得する</br>
     * 社員情報が存在する場合は、employeesに追加し、</br>
     * 存在しない場合は、NULL_EMP をemployeesに追加してください。
     */
    public List<Employee> addEmployee(String name) {
    	List<Employee> employees = fac.getEmployeeList();
    	// TODO: ここに実装を追加してください。
    	return employees;
    }
    /**
     * 課題３　employees から、３５歳の社員情報を1つだけ取得してください。</br>
     * 存在しない場合は、name="" aga=1 のEmployeeを作成して返してください。
     */
    public Employee loadOne35Employee() {
    	List<Employee> employees = fac.getEmployeeList();
    	// TODO: ここに実装を追加してください。
    	return null;
    }
    /**
     * 課題４ employeesから、２０歳以上 一番若い社員情報（1人だけ）を取得してください。</br>
     * 存在しない場合は NoSuchElementException を throw してください。
     */
    public Employee loadUpper20Youngest() {
    	List<Employee> employees = fac.getEmployeeList();
    	// TODO: ここに実装を追加してください。
    	return null;
    }
}
