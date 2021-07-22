package junit.mockAndSpy;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class Mock_And_Spy {


    @Test
    public void add_without_when() {
        List<String> mockedList = mock(List.class);
        mockedList.add("A");
        mockedList.add("B");
        mockedList.add("C");
        assertThat(mockedList.size(), is(0));
    }

    @Test
    public void add_with_when() {
        List<String> mockedList = mock(List.class);
        mockedList.add("A");
        mockedList.add("B");
        mockedList.add("C");
        when(mockedList.size()).thenReturn(10);
        assertThat(mockedList.size(), is(10));
    }

    @Test
    public void call_real_method() {
        Employee employee = mock(Employee.class, Answers.CALLS_REAL_METHODS);
        employee.setId(10);
        employee.setName(new Name("Alice","Smith"));
        assertThat(employee.getId(), is(10));
        assertThat(employee.getName().getFirstName(), is("Alice"));
    }

    @Test
    public void call_real_method_with_when() {
        Employee employee = mock(Employee.class, Answers.CALLS_REAL_METHODS);
        employee.setId(10);
        employee.setName(new Name("Alice","Smith"));
        when(employee.getName()).thenReturn(new Name("Bob", "Smith"));
        assertThat(employee.getId(), is(10));
        assertThat(employee.getName().getFirstName(), is("Bob"));
    }

    @Test
    public void deep_stubs() {
        Employee employee = mock(Employee.class, Answers.RETURNS_DEEP_STUBS);
        when(employee.getName().getFirstName()).thenReturn("Alice");
        assertThat(employee.getName().getFirstName(), is("Alice"));
    }

    @Test
    public void deep_stubs_without_when() {
        Employee employee = mock(Employee.class, Answers.RETURNS_DEEP_STUBS);
        assertThat(employee.getName().getFirstName(), is(nullValue()));
    }

    @Test
    public void no_deep_stub() {
        Employee employee = mock(Employee.class);
        assertThrows(NullPointerException.class, () -> employee.getName().getLastName());
    }

    @Test
    public void no_deep_stub_2() {
        Employee employee = mock(Employee.class);
        try {
            assertThrows(NullPointerException.class, employee.getName()::getLastName);
        } catch (NullPointerException e) {
            fail();
        }
    }

}
