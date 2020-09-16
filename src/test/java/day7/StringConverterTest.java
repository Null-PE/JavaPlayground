package day7;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringConverterTest {
    StringConverter it;

    @Before
    public void setUp() throws Exception {
        it = new StringConverter();
    }

    @Test
    public void sanitizeName_ReturnAsIs_IfArgumentConsistsOfSmallAlphaNumericChars() {
        String actual = it.sanitizeName("atoz0to9");
        String expected = "atoz0to9";
        assertEquals(expected, actual);
    }

    @Test
    public void sanitizeName_ReplaceWithLowerCase_IfArgumentContainsUpperCaseChars() {
        String actual = it.sanitizeName("AtoZ");
        String expected = "atoz";
        assertEquals(expected, actual);
    }

    @Test
    public void sanitizeName_ReplaceWithHyphen_IfArgumentContainsContinuousWhitespaces() {
        String actual = it.sanitizeName("hoge \n\tfuga piyo");
        String expected = "hoge-fuga-piyo";
        assertEquals(expected, actual);
    }

    @Test
    public void sanitizeName_ReplaceWithUnderscores_IfArgumentContainsOtherChars() {
        String actual = it.sanitizeName("japane$e @t 日本語");
        String expected = "japane_e-_t-___";
        assertEquals(expected, actual);
    }

}
