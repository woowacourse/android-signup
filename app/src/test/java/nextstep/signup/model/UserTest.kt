package nextstep.signup.model

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class UserTest {
    @Test
    fun `모든 값이 올바를 때 isInvalid false이다`() {
        // given
        val user = User(
            name = Name(VALID_NAME),
            email = Email(VALID_EMAIL),
            password = Password(VALID_PASSWORD),
            passwordConfirm = PasswordConfirm(VALID_PASSWORD, VALID_PASSWORD)
        )

        // when
        val result = user.isInvalid()

        // then
        assertFalse(result)
    }

    @Test
    fun `조건을 모두 만족하지 않으면 isInvalid true이다`() {
        // given
        val user = User(
            name = Name(INVALID_NAME),
            email = Email(VALID_EMAIL),
            password = Password(VALID_PASSWORD),
            passwordConfirm = PasswordConfirm(VALID_PASSWORD, VALID_PASSWORD)
        )

        // when
        val result = user.isInvalid()

        // then
        assertTrue(result)
    }
}
