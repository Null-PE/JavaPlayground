package junit.mockedStatic;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;

class CompanyContextTest {


    @Test
    void test() {
        try (MockedStatic mocked = mockStatic(TestUtils.class)){
            mocked.when(TestUtils::getInstance).thenReturn("changed");
            assertThat(TestUtils.getInstance(), is("changed"));
            mocked.verify(TestUtils::getInstance,times(1));
        }
        assertThat(TestUtils.getInstance(), is("default"));
    }

}