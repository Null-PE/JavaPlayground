package junit.parameterized;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.time.Month;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.MatcherAssert.assertThat;

public class ParameterizedWithProviderTest {

    @Nested
    @DisplayName("Value Source")
    class ValueSourceTest{
        @ParameterizedTest()
        @ValueSource(ints = {3,1,2})
        void value_test(int input) {
            assertThat(input, isA(Integer.class));
        }
    }

    @Nested
    @DisplayName("About CsvSource")
    class CsvSourceTest{
        @ParameterizedTest()
        @CsvSource(value = {"1,1", "2,2", "3,3"})
        void csv_source(Long a, Long b) {
            assertThat(a, is(b));
        }
    }

    @Nested
    @DisplayName("About EnumSource")
    class EnumSourceTest {
        @ParameterizedTest(name = "{0}")
        @EnumSource(Month.class)
        void enum_test(Month month) {

        }
    }

    @Nested
    @DisplayName("null and empty")
    class null_and_empty {
        @ParameterizedTest(name = "NullSource input is {0}")
        @NullSource
        void null_test(String input) {

        }

        @ParameterizedTest(name = "input is {0}")
        @EmptySource
        void empty_test(List inputs) {
            inputs.forEach(System.out::println);
        }

        @ParameterizedTest(name = "input is {0}")
        @NullAndEmptySource
        void null_and_empty_test(List<String> inputs) {
            inputs.forEach(System.out::println);
        }
    }

}
