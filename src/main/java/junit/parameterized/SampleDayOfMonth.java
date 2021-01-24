package junit.parameterized;

import java.util.Calendar;

public class SampleDayOfMonth {

	/**
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public int getDayOfMonth(int year, int month) {
		switch (month) {
		case Calendar.APRIL:
		case Calendar.JUNE:
		case Calendar.SEPTEMBER:
		case Calendar.NOVEMBER:
			return 30;
		case Calendar.FEBRUARY:
			if(year % 400 == 0 || year % 100 != 0 && year %4 == 0) {
				return 29;
			} else {
				return 28;
			}
		}
		return 31;
	}

}
