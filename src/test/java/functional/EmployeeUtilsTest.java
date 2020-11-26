package functional;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class EmployeeUtilsTest {
    EmployeeUtils utils = new EmployeeUtils();
    List<Employee> employeeList = new ArrayList<>();

    @Before
    public void buildEmployeeList() {
        employeeList.add(new Employee(1,"Alice",20,1));
        employeeList.add(new Employee(2,"Bob",35,1));
        employeeList.add(new Employee(3,"Charlie",25,1));
        employeeList.add(new Employee(4,"David",45,2));
        employeeList.add(new Employee(5,"Even",33,2));
        employeeList.add(new Employee(6,"Frank",52,3));
        employeeList.add(new Employee(7,"Gu",29,3));
    }

    @Test
    public void test() {
        assertThat(String.join("", utils.getNameList(employeeList, 1)), is("AliceBobCharlie"));
        assertThat(String.join("", utils.getNameList(employeeList, 2)), is("DavidEven"));
        assertThat(String.join("", utils.getNameList(employeeList, 3)), is("FrankGu"));
    }

    @Test
    public void test2() {
        assertThat(utils.getAverageAge(employeeList, 1), is(26));
        assertThat(utils.getAverageAge(employeeList, 2), is(39));
        assertThat(utils.getAverageAge(employeeList, 3), is(40));
    }
}
