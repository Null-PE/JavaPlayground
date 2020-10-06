package day21.student;

public class StudentMessageService {

	public String getNumberMessage(Student student) {
		return "出席番号は" + student.getNumber() + "番です";
	}

	public String getFullNameMessage(Student student) {
		return "名前は" + student.getFullName() + "です";
	}
}
