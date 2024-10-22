package nextstep.signup.model

import org.junit.Assert.assertEquals
import org.junit.Test

class PasswordConfirmTest {
    @Test
    fun `비밀번호와 확인용 비밀번호가 일치한다면 passwordConfirmValidResult는 Success가 반환된다`() {
        val passwordConfirmValidResult: PasswordConfirmValidResult = PasswordConfirm("hannah0731").validate("hannah0731")
        assertEquals(PasswordConfirmValidResult.Success, passwordConfirmValidResult)
    }

    @Test
    fun `비밀번호와 확인용 비밀번호가 일치하지 않으면 passwordConfirmValidResult는 Invalid가 반환된다`() {
        val passwordConfirmValidResult: PasswordConfirmValidResult = PasswordConfirm("hannah07").validate("hannah0731")
        assertEquals(PasswordConfirmValidResult.Invalid, passwordConfirmValidResult)
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
}
