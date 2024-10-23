package nextstep.signup.domain

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class PasswordConfirmTest {
    @Test
    fun `비밀번호와 동일하면 유효하다`() {
        // given
        val password = "password123"

        // when
        val passwordConfirm = PasswordConfirm("password123")

        // then
        assertTrue(passwordConfirm.isMatchWithPassword(password))
    }

    @Test
    fun `비밀번호와 다르면 유효하지 않다`() {
        // given
        val password = "password123"

        // when
        val passwordConfirm = PasswordConfirm("password789")

        // then
        assertFalse(passwordConfirm.isMatchWithPassword(password))
    }
}
