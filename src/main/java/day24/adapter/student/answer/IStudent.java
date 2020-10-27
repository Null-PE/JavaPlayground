package day24.adapter.student.answer;

public interface IStudent {

	/**
	 * @return 出席番号
	 */
	int getNumber();

	/**
	 * @return 姓名。姓と名の間には半角スペースが入ります
	 */
	String getFullName();

}