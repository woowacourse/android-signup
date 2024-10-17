package nextstep.signup.model

import nextstep.signup.ui.model.Password
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PasswordTest {
    private val invalidLengthErrorMessage = "비밀번호는 8~16자여야 합니다."
    private val invalidPatternErrorMessage = "비밀번호는 영문과 숫자를 포함해야 합니다."

    @Test
    fun `비밀번호가 유효한 길이와 패턴을 만족하는 경우 에러가 발생하지 않는다`() {
        val validPassword = Password("abc12345")

        assertTrue(validPassword.isValid())
        assertEquals("", validPassword.errorMessage())
    }

    @Test
    fun `비밀번호가 8글자 미만인 경우 길이 에러가 발생한다`() {
        val shortPassword = Password("abc123")

        assertFalse(shortPassword.isValid())
        assertEquals(invalidLengthErrorMessage, shortPassword.errorMessage())
    }

    @Test
    fun `비밀번호가 16글자 초과인 경우 길이 에러가 발생한다`() {
        val longPassword = Password("abc12345678901234")

        assertFalse(longPassword.isValid())
        assertEquals(invalidLengthErrorMessage, longPassword.errorMessage())
    }

    @Test
    fun `비밀번호에 숫자가 포함되지 않은 경우 패턴 에러가 발생한다`() {
        val invalidPatternPassword = Password("abcdefgh")

        assertFalse(invalidPatternPassword.isValid())
        assertEquals(invalidPatternErrorMessage, invalidPatternPassword.errorMessage())
    }

    @Test
    fun `비밀번호에 영문이 포함되지 않은 경우 패턴 에러가 발생한다`() {
        val invalidPatternPassword = Password("12345678")

        assertFalse(invalidPatternPassword.isValid())
        assertEquals(invalidPatternErrorMessage, invalidPatternPassword.errorMessage())
    }
}
