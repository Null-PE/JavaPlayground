package day9;

import day6.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalPractice_answer {
    private static final Employee NULL_EMP = new Employee("NULL", 999);

    /**
     * 課題１　メソッドを完成する
     */
    private static Optional<Employee> findEmployee(String name) {
        return Optional.of(EmployeeFactory.query(name));
    }

    public static void main(String[] args) {
        List<Employee> employees = EmployeeFactory.getEmployeeList();
        /*
        課題２　findEmployee(String name) を使って、社員"Tom"の情報を取得する
        　　　　社員情報が存在すれば、employeesに追加する
               存在しない場合、NULL_EMP　をemployeesに追加する
         */
        employees.add(findEmployee("Tom").orElse(NULL_EMP));
        /*
        課題３　employees から、３５歳の社員情報を1つだけ取る
                存在しない場合は、name="" aga=1 のEmployeeを作成する
         */
        Employee employee3 = employees.stream().filter(e3 -> e3.getAge() == 35)
                .findAny().orElseGet(() -> new Employee("", 1));

        /*
        課題４ employeesから、２０歳以上 一番若い社員情報（1人だけ）を取る、
              存在しない場合は　NoSuchElementException をthrowする
         */
        Employee e4 = employees.stream().filter(employee -> employee.getAge() > 20)
                .min(Comparator.comparingInt(Employee::getAge)).orElseThrow(NoSuchElementException::new);

    }


}
