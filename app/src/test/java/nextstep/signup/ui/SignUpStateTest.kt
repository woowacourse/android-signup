package nextstep.signup.ui

import nextstep.signup.model.Email
import nextstep.signup.model.Password
import nextstep.signup.model.UserName
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class SignUpStateTest {
    @Test
    fun `입력값 중 사용자 이름이 비어있으면 signUpEnabled는 false를 반환한다`() {
        // given & when
        val state =
            SignUpState(
                username = UserName(""),
                email = Email("test@example.com"),
                password = Password("password123"),
                passwordConfirm = Password("password123"),
            )

        // then
        assertFalse(state.enabled)
    }

    @Test
    fun `입력값 중 사용자 이메일이 비어있으면 signUpEnabled는 false를 반환한다`() {
        // given & when
        val stateWithEmailBlank =
            SignUpState(
                username = UserName("user"),
                email = Email(""),
                password = Password("password123"),
                passwordConfirm = Password("password123"),
            )

        // then
        assertFalse(stateWithEmailBlank.enabled)
    }

    @Test
    fun `입력값 중 사용자 비밀번호가 비어있으면 signUpEnabled는 false를 반환한다`() {
        // given & when
        val stateWithPasswordBlank =
            SignUpState(
                username = UserName("user"),
                email = Email("test@example.com"),
                password = Password(""),
                passwordConfirm = Password(""),
            )

        // then
        assertFalse(stateWithPasswordBlank.enabled)
    }

    @Test
    fun `이메일 유효성 검사 실패 시 signUpEnabled는 false를 반환한다`() {
        // given & when
        val invalidEmailState =
            SignUpState(
                username = UserName("user"),
                email = Email("invalid-email"),
                password = Password("password123"),
                passwordConfirm = Password("password123"),
            )

        // then
        assertFalse(invalidEmailState.enabled)
    }

    @Test
    fun `비밀번호 유효성 검사 실패 시 signUpEnabled는 false를 반환한다`() {
        // given & when
        val passwordMismatchState =
            SignUpState(
                username = UserName("user"),
                email = Email("test@example.com"),
                password = Password("password123"),
                passwordConfirm = Password("password321"),
            )

        // then
        assertFalse(passwordMismatchState.enabled)
    }

    @Test
    fun `모든 입력값이 유효하면 signUpEnabled는 true를 반환한다`() {
        // given & when
        val validState =
            SignUpState(
                username = UserName("user"),
                email = Email("test@example.com"),
                password = Password("password123"),
                passwordConfirm = Password("password123"),
            )

        // then
        assertTrue(validState.enabled)
    }
}
