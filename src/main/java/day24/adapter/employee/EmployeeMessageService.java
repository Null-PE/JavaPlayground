package day24.adapter.employee;

public class EmployeeMessageService {

	public String getEmployeeNumberMessage(Employee employee) {
		return "社員番号は" + employee.getEmployeeNumber() + "番です";
	}

	public String getFullnameMessage(Employee employee) {
		return "名前は" + employee.getFullname() + "です";
	}

	public String getAddressMessage(Employee employee) {
		return "住所は" + employee.getAddress() + "です";
	}

	public String getFinalEducationMessage(Employee employee) {
		return "最終学歴は" + employee.getFinalEducation() + "です";
	}

}
