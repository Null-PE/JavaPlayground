package day24.adapter.employee;

public class Employee {

	private String employeeNumber;

	private String fullname;

	private String address;

	private String finalEducation;

	/**
	 * @return 社員番号
	 */
	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	/**
	 * @return 姓名。姓と名の間には半角スペースが入ります
	 */
	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	/**
	 * @return 住所
	 */
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return 最終学歴
	 */
	public String getFinalEducation() {
		return finalEducation;
	}

	public void setFinalEducation(String finalEducation) {
		this.finalEducation = finalEducation;
	}

}
