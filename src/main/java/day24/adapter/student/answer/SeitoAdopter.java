package day24.adapter.student.answer;

import day24.adapter.student.answer.outerlib.Seito;

public class SeitoAdopter implements IStudent {
	private Seito seito;
	public SeitoAdopter(Seito seito) {
		this.seito = seito;
	}
	@Override
	public int getNumber() {
		return seito.getBango();
	}

	@Override
	public String getFullName() {
		return seito.getSei() + " " + seito.getMei();
	}

}
