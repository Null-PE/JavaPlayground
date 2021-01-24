package junit.parameterized;

import java.util.Calendar;

public class MainDayOfMonth {

	/**
	 * 年と月を指定すると日付を返します。
	 */
	public int getDayOfMonth(int year, int month) {
		switch (month) {
		case Calendar.APRIL:
		case Calendar.JUNE:
		case Calendar.SEPTEMBER:
		case Calendar.NOVEMBER:
			return 30;
		case Calendar.FEBRUARY:
			return 28;
		}
		return 31;
	}

}
