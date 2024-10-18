package nextstep.signup.model

import org.junit.Assert.assertEquals
import org.junit.Test

class PasswordTest {
    @Test
    fun `비밀번호가_8에서_16자면_에러_메시지는_null이_반환된다`() {
        val errorMessage: String? = Password("hannah0731").getErrorMessage()
        assertEquals(null, errorMessage)
    }

    @Test
    fun `비밀번호가_8에서_16자가_아니면_에러_메시지가_반환된다`() {
        val errorMessage: String? = Password("hye731").getErrorMessage()
        assertEquals(PASSWORD_LENGTH_ERROR, errorMessage)
    }

    @Test
    fun `비밀번호가_영문과_숫자를_포함하고_있다면_에러_메시지는_null이_반환된다`() {
        val errorMessage: String? = Password("hannah0731").getErrorMessage()
        assertEquals(null, errorMessage)
    }

    @Test
    fun `비밀번호가_영문과_숫자를_포함하고_있지_않다면_에러_메시지가_반환된다`() {
        val errorMessage: String? = Password("gonghyeyeon").getErrorMessage()
        assertEquals(PASSWORD_FORM_ERROR, errorMessage)
    }

    @Test
    fun `비밀번호가_8~16자이고_영문과_숫자를_포함하고_있다면_isInvalid의_값은_false이다`() {
        val isInvalid: Boolean = Password("hannah0731").isInvalid()
        assertEquals(false, isInvalid)
    }

    @Test
    fun `비밀번호가_8~16자가_아니고_영문과_숫자를_포함하고_있지_않다면_isInvalid의_값은_true이다`() {
        val isInvalid: Boolean = Password("hyeyeon").isInvalid()
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