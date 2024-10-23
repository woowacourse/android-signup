package nextstep.signup.domain

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PasswordTest {
    @Test
    fun `비밀번호의 길이가 8자 보다 작으면 유효하지 않다`() {
        // when
        val password = Password("woowaha")

        // then
        assertFalse(password.isValidLength)
    }

    @Test
    fun `비밀번호의 길이가 16자 보다 크면 유효하지 않다`() {
        // when
        val password = Password("passwordMaxSize16")

        // then
        assertFalse(password.isValidLength)
    }

    @Test
    fun `비밀번호에 하나 이상의 알파벳이 포함되지 않으면 유효하지 않다`() {
        // when
        val password = Password("12345678")

        // then
        assertFalse(password.isValidFormat)
    }

    @Test
    fun `비밀번호에 하나 이상의 숫자가 포함되지 않으면 유효하지 않다`() {
        // when
        val password = Password("abcdEfgh")

        // then
        assertFalse(password.isValidFormat)
    }

    @Test
    fun `비밀번호에 알파벳과 숫자가 하나 이상의 포함되며 8~16자 이내라면 유효하다`() {
        // when
        val password = Password("abcd1234@WTC")

        // then
        assertTrue(password.isValid)
    }
}
