package day11;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class YahooMailAddressValidatorTest {

	// https://knowledge.support.yahoo-net.jp/PccHostingupper/s/article/H000004944

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void _引数が半角小文字のみであればTRUEを返す() {
		assertTrue(YahooMailAddressValidator.isValid("kobayashi"));// kobayashi@yahoo.co.jp
	}

	public void _引数が数字のみであればTRUEを返す() {
		assertTrue(YahooMailAddressValidator.isValid("1077")); // 1077@yahoo.co.jp
	}

	public void _引数がハイフンで始まる場合はFalseを返す() {
		assertFalse(YahooMailAddressValidator.isValid("-test-123"));// -test23@yahoo.co.jp
	}

	public void _引数がドットで始まる場合はFalseを返す() {
		assertFalse(YahooMailAddressValidator.isValid(".test-123"));// -test23@yahoo.co.jp
	}

	public void _引数がアンダーバーで始まる場合はFalseを返す() {
		assertFalse(YahooMailAddressValidator.isValid("_test-123"));// _test23@yahoo.co.jp
	}

	public void _引数がドットを連続で使用している場合はFalseを返す() {
		assertFalse(YahooMailAddressValidator.isValid("ab..cs"));
	}

	public void _ハイフンを連続で使用している場合はFalseを返す() {
		assertFalse(YahooMailAddressValidator.isValid("ab--cs"));
	}

}
