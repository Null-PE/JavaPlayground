package day9;

import day6.Employee;

import java.util.*;

public class OptionalPractice {
    private static final Employee NULL_EMP = new Employee("NULL", 999);

    /**
     * 課題１　メソッドを完成する
     */
    private static Optional<Employee> findEmployee(String name) {
        Employee e = EmployeeFactory.query(name);

    }

    public static void main(String[] args) {
        List<Employee> employees = EmployeeFactory.getEmployeeList();
        /*
        課題２　findEmployee(String name) を使って、社員"Tom"の情報を取得する
        　　　　社員情報が存在すれば、employeesに追加する
               存在しない場合、NULL_EMP　をemployeesに追加する
         */

        /*
        課題３　employees から、３５歳の社員情報を1つだけ取る
                存在しない場合は、name="" aga=1 のEmployeeを作成する
         */

        /*
        課題４ employeesから、２０歳以上 一番若い社員情報（1人だけ）を取る、
              存在しない場合は　NoSuchElementException をthrowする
         */

    }


}
