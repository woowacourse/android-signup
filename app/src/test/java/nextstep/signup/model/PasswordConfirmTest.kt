package nextstep.signup.model

import nextstep.signup.ui.model.PasswordConfirm
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PasswordConfirmTest {
    private val passwordMismatchErrorMessage = "비밀번호가 일치하지 않습니다."

    @Test
    fun `비밀번호와 비밀번호 확인이 일치하는 경우 에러가 발생하지 않는다`() {
        val passwordConfirm = PasswordConfirm("abc12345", "abc12345")

        assertTrue(passwordConfirm.isValid())
        assertEquals("", passwordConfirm.errorMessage())
    }

    @Test
    fun `비밀번호와 비밀번호 확인이 일치하지 않는 경우 에러가 발생한다`() {
        val passwordConfirm = PasswordConfirm("abc12345", "abc54321")

        assertFalse(passwordConfirm.isValid())
        assertEquals(passwordMismatchErrorMessage, passwordConfirm.errorMessage())
    }
}
