package day24.adapter.employee.outerlib;

import java.util.List;

public class Syain {

	private String syainBango;

	private String sei;
	private String mei;

	private String jyusyo1;
	private String jyusyo2;
	private String jyusyo3;

	private List<String> gakureki;

	/**
	 * @return 社員番号
	 */
	public String getSyainBango() {
		return syainBango;
	}

	public void setSyainBango(String syainBango) {
		this.syainBango = syainBango;
	}

	/**
	 * @return 姓
	 */
	public String getSei() {
		return sei;
	}

	public void setSei(String sei) {
		this.sei = sei;
	}

	/**
	 * @return 名
	 */
	public String getMei() {
		return mei;
	}

	public void setMei(String mei) {
		this.mei = mei;
	}

	/**
	 * @return 住所1。都道府県
	 */
	public String getJyusyo1() {
		return jyusyo1;
	}

	public void setJyusyo1(String jyusyo1) {
		this.jyusyo1 = jyusyo1;
	}

	/**
	 * @return 住所2。市区町村
	 */
	public String getJyusyo2() {
		return jyusyo2;
	}

	public void setJyusyo2(String jyusyo2) {
		this.jyusyo2 = jyusyo2;
	}

	/**
	 * @return 住所3。住所2より先の住所
	 */
	public String getJyusyo3() {
		return jyusyo3;
	}

	public void setJyusyo3(String jyusyo3) {
		this.jyusyo3 = jyusyo3;
	}

	/**
	 * @return 古い順の学歴リスト
	 */
	public List<String> getGakureki() {
		return gakureki;
	}

	public void setGakureki(List<String> gakureki) {
		this.gakureki = gakureki;
	}

}
