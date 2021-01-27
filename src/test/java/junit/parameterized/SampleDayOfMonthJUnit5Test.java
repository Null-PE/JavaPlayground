package junit.parameterized;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.Calendar;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

@SuppressWarnings("boxing")
public class SampleDayOfMonthJUnit5Test extends SampleDayOfMonth {

	@ParameterizedTest
	@MethodSource("data")
	void testDayOfMonth_byMethodSource(int year, int month, int expected) {
		int day = getDayOfMonth(year, month);
		assertThat(day, is(expected));
	}

	static Stream<Arguments> data() {
		return Stream.of(
				Arguments.of(2019, Calendar.JANUARY, 31),
				Arguments.of(2019, Calendar.FEBRUARY, 28),
				Arguments.of(2019, Calendar.MARCH, 31),
				Arguments.of(2019, Calendar.APRIL, 30),
				Arguments.of(2019, Calendar.MAY, 31),
				Arguments.of(2019, Calendar.JUNE, 30),
				Arguments.of(2019, Calendar.JULY, 31),
				Arguments.of(2019, Calendar.AUGUST, 31),
				Arguments.of(2019, Calendar.SEPTEMBER, 30),
				Arguments.of(2019, Calendar.OCTOBER, 31),
				Arguments.of(2019, Calendar.NOVEMBER, 30),
				Arguments.of(2019, Calendar.DECEMBER, 31),
				Arguments.of(2020, Calendar.FEBRUARY, 29),// うるう年
				Arguments.of(1900, Calendar.FEBRUARY, 28),// うるう年(例外:100年)
				Arguments.of(2000, Calendar.FEBRUARY, 29)//うるう年(例外の例外:400年)
				);
	}

	@ParameterizedTest
	@CsvSource({
			"2019,1,31",
			"2019,2,28",
			"2019,3,31",
			"2019,4,30",
			"2019,5,31",
			"2019,6,30",
			"2019,7,31",
			"2019,8,31",
			"2019,9,30",
			"2019,10,31",
			"2019,11,30",
			"2019,12,31",
			"2020,2,29",// うるう年
			"1900,2,28",// うるう年(例外:100年)
			"2000,2,29",//うるう年(例外の例外:400年)
	})
	void testDayOfMonth_byCsvSource(int year, int month, int expected) {
		month--; // Calendarは0始まりのため、-1する
		int day = getDayOfMonth(year, month);
		assertThat(day, is(expected));
	}
}
