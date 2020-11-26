package functional;

import java.util.ArrayList;
import java.util.List;

public class EmployeeUtils {

    public List<String> getNameList(List<Employee> employeeList, int divNo) {
        List<String> nameList = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getDivNo() == divNo) {
                nameList.add(employee.getName());
            }
        }
        return nameList;
    }

    public int getAverageAge(List<Employee> employeeList, int divNo) {
        int count = 0;
        int totalAge = 0;
        for (Employee employee : employeeList) {
            if (employee.getDivNo() == divNo) {
                count++;
                totalAge += employee.getAge();
            }
        }
        if (count == 0) {
            return 0;
        }
        return totalAge / count;
    }

}
