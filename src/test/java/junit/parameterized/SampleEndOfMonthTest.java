package junit.parameterized;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Calendar;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Enclosed.class)
public class SampleEndOfMonthTest {

	// Parameterizedを使ったテスト
	@RunWith(Parameterized.class)
	public static class DayOfMonthTest {
		private int year;
		private int month;
		private int expected;
		private SampleDayOfMonth sampleDayOfMonth;
		public DayOfMonthTest(int year, int month, int expected) {
			super();
			this.year = year;
			this.month = month;
			this.expected = expected;
			this.sampleDayOfMonth = new SampleDayOfMonth();
		}

		@Parameters
		public static Iterable<Object[]> data() {
			return Arrays.asList(new Object[][] {
										{2019, Calendar.JANUARY, 31},
										{2019, Calendar.FEBRUARY, 28},
										{2019, Calendar.MARCH, 31},
										{2019, Calendar.APRIL, 30},
										{2019, Calendar.MAY, 31},
										{2019, Calendar.JUNE, 30},
										{2019, Calendar.JULY, 31},
										{2019, Calendar.AUGUST, 31},
										{2019, Calendar.SEPTEMBER, 30},
										{2019, Calendar.OCTOBER, 31},
										{2019, Calendar.NOVEMBER, 30},
										{2019, Calendar.DECEMBER, 31},
										{2020, Calendar.FEBRUARY, 29},// うるう年
										{1900, Calendar.FEBRUARY, 28},// うるう年(例外:100年)
										{2000, Calendar.FEBRUARY, 29},//うるう年(例外の例外:400年)
										
			});
		}
		@Test
		public void testDayOfMonth() {
			int day = sampleDayOfMonth.getDayOfMonth(year, month);
			assertThat(day, is(expected));
		}
	}
	
	//Theories を使ったテスト
	@RunWith(Theories.class)
	public static class DayOfMonthTheoriesTest {
		private SampleDayOfMonth sampleDayOfMonth;
		public DayOfMonthTheoriesTest() {
			sampleDayOfMonth = new SampleDayOfMonth();
		}
		@DataPoints
		public static Fixture[] params = {
				new Fixture(2019, Calendar.JANUARY, 31),
				new Fixture(2019, Calendar.FEBRUARY, 28),
				new Fixture(2019, Calendar.MARCH, 31),
				new Fixture(2019, Calendar.APRIL, 30),
				new Fixture(2019, Calendar.MAY, 31),
				new Fixture(2019, Calendar.JUNE, 30),
				new Fixture(2019, Calendar.JULY, 31),
				new Fixture(2019, Calendar.AUGUST, 31),
				new Fixture(2019, Calendar.SEPTEMBER, 30),
				new Fixture(2019, Calendar.OCTOBER, 31),
				new Fixture(2019, Calendar.NOVEMBER, 30),
				new Fixture(2019, Calendar.DECEMBER, 31),
				new Fixture(2020, Calendar.FEBRUARY, 29),// うるう年
				new Fixture(1900, Calendar.FEBRUARY, 28),// うるう年(例外:100年)
				new Fixture(2000, Calendar.FEBRUARY, 29),//うるう年(例外の例外:400年)
				
		};
		@Theory
		public void testDayOfMonth(Fixture p) {
			int day = sampleDayOfMonth.getDayOfMonth(p.year, p.month);
			assertThat(day, is(p.expected));
		}
		
		static class Fixture {
			int year;
			int month;
			int expected;
			public Fixture(int year, int month, int expected) {
				this.year = year;
				this.month = month;
				this.expected = expected;
			}
		}
	}
}
