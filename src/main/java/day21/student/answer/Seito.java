package day21.student.answer;

public class Seito implements IStudent {

	private int bango;

	private String sei;
	private String mei;

	public int getBango() {
		return bango;
	}

	public void setBango(int bango) {
		this.bango = bango;
	}

	public String getSei() {
		return sei;
	}

	public void setSei(String sei) {
		this.sei = sei;
	}

	public String getMei() {
		return mei;
	}

	public void setMei(String mei) {
		this.mei = mei;
	}

	@Override
	public int getNumber() {
		return getBango();
	}

	@Override
	public String getFullName() {
		return getSei() + " " + getMei();
	}

}
