package day21.student.answer;

public class StudentMessageService {

	public String getNumberMessage(IStudent student) {
		return "出席番号は" + student.getNumber() + "番です";
	}

	public String getFullNameMessage(IStudent student) {
		return "名前は" + student.getFullName() + "です";
	}
}
