package day24.adapter.student;

public class Student {

	private int number;
	private String fullName;

	/**
	 * @return 出席番号
	 */
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return 姓名。姓と名の間には半角スペースが入ります
	 */
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
