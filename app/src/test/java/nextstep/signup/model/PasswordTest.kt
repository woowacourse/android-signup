package nextstep.signup.model

import nextstep.signup.R
import nextstep.signup.presentation.model.Password
import org.junit.Assert
import org.junit.Test

class PasswordTest {
    @Test
    fun `비밀번호가 비어있을 때 유효성 검사가 통과된다`() {
        // given
        val password = Password("")

        // when
        val result = password.validate()

        // then
        Assert.assertFalse(result.isError)
    }

    @Test
    fun `비밀번호가 8자에서 16자 사이일 경우 유효성 검사가 통과된다`() {
        // given
        val password = Password("abc12345")

        // when
        val result = password.validate()

        // then
        Assert.assertFalse(result.isError)
    }

    @Test
    fun `비밀번호가 8자 미만일 경우 유효성 검사가 실패한다`() {
        // given
        val password = Password("abc1234")

        // when
        val result = password.validate()

        // then
        Assert.assertTrue(result.isError)
        Assert.assertEquals(result.errorMessageRes, R.string.error_password_length)
    }

    @Test
    fun `비밀번호가 16자를 초과할 경우 유효성 검사가 실패한다`() {
        // given
        val password = Password("abc12345abc123456")

        // when
        val result = password.validate()

        // then
        Assert.assertTrue(result.isError)
        Assert.assertEquals(result.errorMessageRes, R.string.error_password_length)
    }

    @Test
    fun `비밀번호에 알파벳과 숫자가 포함되지 않으면 유효성 검사가 실패한다`() {
        // given
        val password = Password("abcdefgh")

        // when
        val result = password.validate()

        // then
        Assert.assertTrue(result.isError)
        Assert.assertEquals(result.errorMessageRes, R.string.error_password_requirements)
    }

    @Test
    fun `비밀번호 확인이 일치할 경우 비밀번호 일치 유효성 검사가 통과된다`() {
        // given
        val password = Password("abc12345")
        val confirmPassword = Password("abc12345")

        // when
        val result = password.validateConfirmation(confirmPassword)

        // then
        Assert.assertFalse(result.isError)
    }

    @Test
    fun `비밀번호 확인이 일치하지 않을 경우 비밀번호 일치 유효성 검사가 실패한다`() {
        // given
        val password = Password("abc12345")
        val confirmPassword = Password("abc54321")

        // when
        val result = confirmPassword.validateConfirmation(password)

        // then
        Assert.assertTrue(result.isError)
        Assert.assertEquals(result.errorMessageRes, R.string.error_password_mismatch)
    }

    @Test
    fun `비밀번호 확인 값이 비어있을 경우 비밀번호 일치 유효성 검사가 통과된다`() {
        // given
        val password = Password("abc12345")
        val confirmPassword = Password("")

        // when
        val result = confirmPassword.validateConfirmation(password)

        // then
        Assert.assertFalse(result.isError)
    }
}
