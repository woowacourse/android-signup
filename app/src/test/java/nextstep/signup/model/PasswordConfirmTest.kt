package nextstep.signup.model

import org.junit.Assert.assertEquals
import org.junit.Test

class PasswordConfirmTest {
    @Test
    fun `비밀번호와_확인용_비밀번호는_일치한다면_에러메시지는_null을_반환한다`() {
        val errorMessage: String? = PasswordConfirm("hannah0731").getErrorMessage("hannah0731")
        assertEquals(null, errorMessage)
    }

    @Test
    fun `비밀번호와_확인용_비밀번호가_일치하지_않으면_에러메시지가_노출된다`() {
        val errorMessage: String? = PasswordConfirm("hannah07").getErrorMessage("hannah0731")
        assertEquals(PASSWORD_CONFIRM_ERROR, errorMessage)
    }

    @Test
    fun `확인용_비밀번호가_비어있다면_isValid의_값은_true이다`() {
        val isValid: Boolean = PasswordConfirm("").isValid("hannah0731")
        assertEquals(true, isValid)
    }

    companion object {
        private const val PASSWORD_CONFIRM_ERROR = "비밀번호가 일치하지 않습니다."
    }
}
