package nextstep.signup.model

import org.junit.Assert.assertEquals
import org.junit.Test

class PasswordConfirmTest {
    @Test
    fun `비밀번호와 확인용 비밀번호가 일치한다면 에러메시지는 null을 반환한다`() {
        val errorMessage: String? = PasswordConfirm("hannah0731").getErrorMessage("hannah0731")
        assertEquals(null, errorMessage)
    }

    @Test
    fun `비밀번호와 확인용 비밀번호가 일치하지 않으면 에러메시지를 반환한다`() {
        val errorMessage: String? = PasswordConfirm("hannah07").getErrorMessage("hannah0731")
        assertEquals(PASSWORD_CONFIRM_ERROR, errorMessage)
    }

    @Test
    fun `비밀번호와 확인용 비밀번호가 일치한다면 isMatch의 상태는 true이다`() {
        val isMatch: Boolean = PasswordConfirm("hannah0731").isMatch("hannah0731")
        assertEquals(true, isMatch)
    }

    @Test
    fun `비밀번호와 확인용 비밀번호가 일치하지 않는다면 isMatch의 상태는 false이다`() {
        val isMatch: Boolean = PasswordConfirm("hannah0731").isMatch("hannah07")
        assertEquals(false, isMatch)
    }

    @Test
    fun `확인용 비밀번호가 비어있다면 isError의 값은 true이다`() {
        val isError: Boolean = PasswordConfirm("").isError("hannah0731")
        assertEquals(false, isError)
    }

    companion object {
        private const val PASSWORD_CONFIRM_ERROR = "비밀번호가 일치하지 않습니다."
    }
}
