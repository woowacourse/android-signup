package nextstep.signup.model

import org.junit.Assert.assertEquals
import org.junit.Test

class PasswordTest {
    @Test
    fun `비밀번호가 8자 이상 16자 이하라면 에러 메시지는 null이 반환된다`() {
        val errorMessage: String? = Password("hannah0731").getErrorMessage()
        assertEquals(null, errorMessage)
    }

    @Test
    fun `비밀번호가 8자 미만이라면 에러 메시지가 반환된다`() {
        val errorMessage: String? = Password("hye731").getErrorMessage()
        assertEquals(PASSWORD_LENGTH_ERROR, errorMessage)
    }

    @Test
    fun `비밀번호가 16자 초과라면 에러 메시지가 반환된다`() {
        val errorMessage: String? = Password("hannah731gonghyeyeon").getErrorMessage()
        assertEquals(PASSWORD_LENGTH_ERROR, errorMessage)
    }

    @Test
    fun `비밀번호가 영문과 숫자를 포함하고 있다면 에러 메시지는 null이 반환된다`() {
        val errorMessage: String? = Password("hannah0731").getErrorMessage()
        assertEquals(null, errorMessage)
    }

    @Test
    fun `비밀번호가 숫자를 포함하지 않으면 에러 메시지가 반환된다`() {
        val errorMessage: String? = Password("gonghyeyeon").getErrorMessage()
        assertEquals(PASSWORD_FORM_ERROR, errorMessage)
    }

    @Test
    fun `비밀번호가 영문을 포함하지 않으면 에러 메시지가 반환된다`() {
        val errorMessage: String? = Password("1234567899").getErrorMessage()
        assertEquals(PASSWORD_FORM_ERROR, errorMessage)
    }

    @Test
    fun `비밀번호가 영문과 숫자를 포함하지 않으면 에러 메시지가 반환된다`() {
        val errorMessage: String? = Password("해나해나해나@#$").getErrorMessage()
        assertEquals(PASSWORD_FORM_ERROR, errorMessage)
    }

    @Test
    fun `비밀번호가 8~16자이고 영문과 숫자를 포함하고 있다면 isValid의 값은 true이다`() {
        val isValid: Boolean = Password("hannah0731").isValid()
        assertEquals(true, isValid)
    }

    @Test
    fun `비밀번호가 8자 미만이라면 isValid의 값은 false이다`() {
        val isValid: Boolean = Password("hye731").isValid()
        assertEquals(false, isValid)
    }

    @Test
    fun `비밀번호가 16자 초과라면 isValid의 값은 false이다`() {
        val isValid: Boolean = Password("hannah731gonghyeyeon").isValid()
        assertEquals(false, isValid)
    }

    @Test
    fun `비밀번호가 숫자를 포함하지 않으면 isValid의 값은 false이다`() {
        val isValid: Boolean = Password("gonghyeyeon").isValid()
        assertEquals(false, isValid)
    }

    @Test
    fun `비밀번호가 영문을 포함하지 않으면 isValid의 값은 false이다`() {
        val isValid: Boolean = Password("1234567899").isValid()
        assertEquals(false, isValid)
    }

    @Test
    fun `비밀번호가 8~16자가 아니고 영문과 숫자를 포함하고 있지 않다면 isValid의 값은 false이다`() {
        val isValid: Boolean = Password("해나@#\$").isValid()
        assertEquals(false, isValid)
    }

    @Test
    fun `비밀번호가_비어있다면_isValid의_값은_true이다`() {
        val isValid: Boolean = Password("").isValid()
        assertEquals(true, isValid)
    }

    companion object {
        private const val PASSWORD_LENGTH_ERROR = "비밀번호는 8~16자여야 합니다."
        private const val PASSWORD_FORM_ERROR = "비밀번호는 영문과 숫자를 포함해야 합니다."
    }
}
