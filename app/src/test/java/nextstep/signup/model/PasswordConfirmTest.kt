package nextstep.signup.model

import org.junit.Assert.assertTrue
import org.junit.Assert.assertFalse
import org.junit.Assert.assertEquals
import org.junit.Test

class PasswordConfirmTest{
    @Test
    fun `비밀번호 확인 값이 비밀번호 값과 다르다면 isInavalid는 true이다`() {
        // given
        val password = PasswordConfirm("1q", "2q")

        // when
        val result = password.isInvalid()

        // then
        assertTrue(result)
    }

    @Test
    fun `비밀번호 확인 값이 비밀번호 값과 다르다면 올바른 에러 메시지를 반환한다`() {
        // given
        val password = PasswordConfirm("1q", "2q")

        // when
        val errorMessage = password.getErrorMessage()

        // then
        assertEquals(PasswordConfirm.ERROR_USER_PASSWORD_CONFIRM, errorMessage)
    }

    @Test
    fun `비밀번호 확인 값이 비밀번호 값과 같다면 isInavalid는 false이다`() {
        // given
        val password = PasswordConfirm(VALID_PASSWORD, VALID_PASSWORD)

        // when
        val result = password.isInvalid()

        // then
        assertFalse(result)
    }

}
