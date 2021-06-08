package day26;

import org.junit.Test;
import org.junit.Before;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * People Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Oct 14, 2020</pre>
 */
public class PeopleTest {
    People people;
    Dog dog;
    Cat cat;

    @Before
    public void before() {
        people = new People();
        dog = new Dog("Daisy");
        cat = new Cat("Tom");
    }


    /**
     * Method: setPet(Dog pet)
     */
    @Test
    public void feedDog() {
        assertThat(people.feedPet(dog), is("Daisyが肉を食べた。"));
    }

    @Test
    public void feedCat() {
//        assertThat(people.feedPet(cat), is("Tomが魚を食べた。"));
    }


}
