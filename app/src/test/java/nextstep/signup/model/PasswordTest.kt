package nextstep.signup.model

import org.junit.Assert.assertEquals
import org.junit.Test

class PasswordTest {
    @Test
    fun `비밀번호가 8자에서 16자 사이라면 유효하다`() {
        val password = Password("password12")

        val result = password.validate()
        val expect = ValidationState.Valid
        assertEquals(expect, result)
    }

    @Test
    fun `비밀번호가 8자에서 16자가 아니면 유효하지 않다 - 8글자보다 짧은 경우`() {
        val password = Password("pw12")

        val result = password.validate()
        val expect = ValidationState.Invalid.Password.Length
        assertEquals(expect, result)
    }

    @Test
    fun `비밀번호가 8자에서 16자가 아니면 유효하지 않다 - 16글자보다 긴 경우`() {
        val password = Password("password123password123")

        val result = password.validate()
        val expect = ValidationState.Invalid.Password.Length
        assertEquals(expect, result)
    }

    @Test
    fun `비밀번호에는 영문과 숫자가 포함되어야 한다`() {
        val password = Password("password12")

        val result = password.validate()
        val expect = ValidationState.Valid
        assertEquals(expect, result)
    }

    @Test
    fun `비밀번호에 영문이 포함되어 있지 않으면 유효하지 않다`() {
        val password = Password("12345678")

        val result = password.validate()
        val expect = ValidationState.Invalid.Password.Format
        assertEquals(expect, result)
    }

    @Test
    fun `비밀번호에 숫자가 포함되어 있지 않으면 유효하지 않다`() {
        val password = Password("password")

        val result = password.validate()
        val expect = ValidationState.Invalid.Password.Format
        assertEquals(expect, result)
    }
}
