package optional;

import java.util.List;
import java.util.Optional;

import common.Employee;

public interface IOptionalPractice {
	public static final Employee NULL_EMP = new Employee("NULL", 999);
	/**
	 * 課題１　メソッドを完成する
	 */
	Optional<Employee> findEmployee(String name);

	/**
	 * 課題２　findEmployee(String name) を使って、社員"Tom"の情報を取得する
	   社員情報が存在すれば、employeesに追加する
	   存在しない場合、NULL_EMP　をemployeesに追加する
	 */
	List<Employee> addEmployee(String name);

	/**
	 * 課題３　employees から、３５歳の社員情報を1つだけ取る
	 * 存在しない場合は、name="" aga=1 のEmployeeを作成する
	 */
	Employee loadOne35Employee();

	/**
	 * 課題４ employeesから、２０歳以上 一番若い社員情報（1人だけ）を取る、
	 * 存在しない場合は　NoSuchElementException をthrowする
	 */
	Employee loadUpper20Youngest();

}