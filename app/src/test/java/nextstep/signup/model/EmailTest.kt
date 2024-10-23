package nextstep.signup.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class EmailTest {
    @Test
    fun `이메일 값이 이메일 형식이 아닐 때 isInvalid는 true이다`() {
        // given
        val email = Email("a")

        // when
        val result = email.isInvalid()

        // then
        assertTrue(result)
    }

    @Test
    fun `이메일 값이 이메일 형식이 아닐 때 올바른 에러를 반환한다`() {
        // given
        val email = Email("a")

        // when
        val error = email.getValidationError()

        // then
        assertEquals(InputError.EmailError.InvalidFormat, error)
    }

    @Test
    fun `이메일 값이 이메일 형식이 맞을 때 isInvalid는 false이다`() {
        // given
        val email = Email(VALID_EMAIL)

        // when
        val result = email.isInvalid()

        // then
        assertFalse(result)
    }
}
