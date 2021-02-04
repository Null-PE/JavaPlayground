package useraccount.traditional;

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class UserAccountServiceTraditionalImplTest extends UserAccountServiceTraditionalImpl {

	UserAccountServiceTraditionalImplTest() {
		super(mock(UserAccountDao.class));
	}

	@Nested
	class _3文字以上のuserNameは許可される {
		@Test
		void 作成時に3文字のuserNameは許可される() {
			createUser(123, "abc");
		}

	}

	@Nested
	class _3文字未満のuserNameは許可されない {
		@Test
		void 作成時に2文字のuserNameは許可されない() {
			assertThrows(IllegalArgumentException.class, () -> createUser(123, "ab"));
		}
	}

}
