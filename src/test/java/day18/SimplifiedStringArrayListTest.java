package day18;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class SimplifiedStringArrayListTest {

	SimplifiedStringArrayList it = new SimplifiedStringArrayList(3);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void 初期サイズ内でaddされた要素をgetで取り出せる() {
		it.add("a");
		it.add("b");
		it.add("c");
		assertThat(it.get(0), is("a"));
		assertThat(it.get(1), is("b"));
		assertThat(it.get(2), is("c"));
	}

	@Test
	public void 初期サイズ外でaddされた要素をgetで取り出せる() {
		it.add("a");
		it.add("b");
		it.add("c");
		it.add("d");
		assertThat(it.get(0), is("a"));
		assertThat(it.get(1), is("b"));
		assertThat(it.get(2), is("c"));
		assertThat(it.get(3), is("d"));
	}

	@Test
	public void testToString() {
		it.add("a");
		it.add("b");
		it.add("c");
		it.add("d");
		assertThat(it.toString(), is("abcd"));
	}

}
