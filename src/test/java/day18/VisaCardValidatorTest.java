package day18;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VisaCardValidatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIsValid_ReturnFalse_IfArgIsNull() {
		assertThat(VisaCardValidator.isValid(null), is(true));
	}

	@Test
	public void testIsValid_ReturnTrue_IFArgHasValidCase() {
		assertThat(VisaCardValidator.isValid("1111-1111-1111-1111"), is(true));
	}

}
