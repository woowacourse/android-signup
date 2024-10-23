package nextstep.signup.model

import org.junit.Assert.assertEquals
import org.junit.Test

class PasswordConfirmTest {
    @Test
    fun `비밀번호와 확인용 비밀번호가 일치한다면 유효성 검증에 성공한다`() {
        val passwordConfirmValidResult: PasswordConfirmValidResult = PasswordConfirm("hannah0731").validate("hannah0731")
        assertEquals(PasswordConfirmValidResult.Success, passwordConfirmValidResult)
    }

    @Test
    fun `비밀번호와 확인용 비밀번호가 일치하지 않으면 유효성 검증에 실패한다`() {
        val passwordConfirmValidResult: PasswordConfirmValidResult = PasswordConfirm("hannah07").validate("hannah0731")
        assertEquals(PasswordConfirmValidResult.Invalid, passwordConfirmValidResult)
    }

    @Test
    fun `비밀번호와 확인용 비밀번호가 일치한다면 유효하다`() {
        val isMatch: Boolean = PasswordConfirm("hannah0731").isMatch("hannah0731")
        assertEquals(true, isMatch)
    }

    @Test
    fun `비밀번호와 확인용 비밀번호가 일치하지 않는다면 유효하지 않다`() {
        val isMatch: Boolean = PasswordConfirm("hannah0731").isMatch("hannah07")
        assertEquals(false, isMatch)
    }

    @Test
    fun `확인용 비밀번호가 비어있는 상태는 오류가 아니다`() {
        val isError: Boolean = PasswordConfirm("").isError("hannah0731")
        assertEquals(false, isError)
    }
}
