package functional;

public class Employee implements Comparable<Employee> {
    private int empNo;
    private String name;
    private int age;
    private int divNo;


    public Employee(int empNo, String name) {
        this.empNo = empNo;
        this.name = name;
    }

    public Employee(int empNo, String name, int age, int divNo) {
        this.empNo = empNo;
        this.name = name;
        this.age = age;
        this.divNo = divNo;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empNo=" + empNo +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", divNo=" + divNo +
                '}';
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDivNo() {
        return divNo;
    }

    public void setDivNo(int divNo) {
        this.divNo = divNo;
    }

    @Override
    public int compareTo(Employee e) {
        return Integer.compare(empNo, e.getEmpNo());
    }
}
