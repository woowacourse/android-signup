package nextstep.signup.model

import org.junit.Assert.assertEquals
import org.junit.Test

class PasswordConfirmTest {
    @Test
    fun `비밀번호 확인 값은 비밀번호와 동일해야 유효하다`() {
        val password = "password12"
        val passwordConfirm = PasswordConfirm(password, "password12")

        val result = passwordConfirm.validate()
        val expect = ValidationState.Valid
        assertEquals(expect, result)
    }

    @Test
    fun `비밀번호 확인 값은 비밀번호와 동일하지 않다면 유효하지 않다`() {
        val password = "password12"
        val passwordConfirm = PasswordConfirm(password, "password")

        val result = passwordConfirm.validate()
        val expect = ValidationState.Invalid.ConfirmMismatch
        assertEquals(expect, result)
    }
}
