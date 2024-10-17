package nextstep.signup.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PasswordTest {
    @Test
    fun `비밀번호가 8자에서 16자 사이라면 유효하다`() {
        val password = Password("password12")

        assertTrue(password.isValid())
    }

    @Test
    fun `비밀번호가 8자에서 16자가 아니면 유효하지 않다`() {
        val password = Password("pw12")

        assertFalse(password.isValid())
        assertEquals(password.getErrorMessage(), Password.ERROR_PASSWORD_LENGTH_MESSAGE)
    }

    @Test
    fun `비밀번호에는 영문과 숫자가 포함되어야 한다`() {
        val password = Password("password12")

        assertTrue(password.isValid())
    }

    @Test
    fun `비밀번호에 영문이 포함되어 있지 않으면 유효하지 않다`() {
        val password = Password("12345678")

        assertFalse(password.isValid())
        assertEquals(password.getErrorMessage(), Password.ERROR_PASSWORD_FORMAT_MESSAGE)
    }

    @Test
    fun `비밀번호에 숫자가 포함되어 있지 않으면 유효하지 않다`() {
        val password = Password("password")

        assertFalse(password.isValid())
        assertEquals(password.getErrorMessage(), Password.ERROR_PASSWORD_FORMAT_MESSAGE)
    }
}
