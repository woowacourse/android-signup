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
    fun `비밀번호가_영문과_숫자를_포함하고_있다면_에러_메시지는_null이_반환된다`() {
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
    fun `비밀번호가_8~16자이고_영문과_숫자를_포함하고_있다면_isInvalid의_값은_false이다`() {
        val isInvalid: Boolean = Password("hannah0731").isInvalid()
        assertEquals(false, isInvalid)
    }

    @Test
    fun `비밀번호가_8자 미만이라면_isInvalid의_값은_true이다`() {
        val isInvalid: Boolean = Password("hye731").isInvalid()
        assertEquals(true, isInvalid)
    }

    @Test
    fun `비밀번호가_16자 초과라면 isInvalid의 값은 true이다`() {
        val isInvalid: Boolean = Password("hannah731gonghyeyeon").isInvalid()
        assertEquals(true, isInvalid)
    }

    @Test
    fun `비밀번호가 숫자를 포함하지 않으면 isInvalid의 값은 true이다`() {
        val isInvalid: Boolean = Password("gonghyeyeon").isInvalid()
        assertEquals(true, isInvalid)
    }

    @Test
    fun `비밀번호가 영문을 포함하지 않으면 isInvalid의 값은 true이다`() {
        val isInvalid: Boolean = Password("1234567899").isInvalid()
        assertEquals(true, isInvalid)
    }

    @Test
    fun `비밀번호가_8~16자가_아니고_영문과_숫자를_포함하고_있지_않다면_isInvalid의_값은_true이다`() {
        val isInvalid: Boolean = Password("해나@#\$").isInvalid()
        assertEquals(true, isInvalid)
    }

    @Test
    fun `비밀번호가_비어있다면_isInvalid의_값은_false이다`() {
        val isInvalid: Boolean = Password("").isInvalid()
        assertEquals(false, isInvalid)
    }

    companion object {
        private const val PASSWORD_LENGTH_ERROR = "비밀번호는 8~16자여야 합니다."
        private const val PASSWORD_FORM_ERROR = "비밀번호는 영문과 숫자를 포함해야 합니다."
    }
}
