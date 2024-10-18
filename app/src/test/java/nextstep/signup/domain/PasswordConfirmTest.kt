package nextstep.signup.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class PasswordConfirmTest {
    @Test
    fun `비밀번호 확인 입력이 공백이면 공백 비밀번호 결과가 리턴`() {
        // given
        val passwordInput = "qwer12345"
        val passwordConfirmInput = ""

        // when
        val passwordConfirmResult = PasswordConfirm.from(
            passwordInput,
            passwordConfirmInput
        )
        // then
        passwordConfirmResult shouldBe PasswordConfirmResult.EmptyField
    }

    @Test
    fun `비밀번호 입력과 비밀번호 확인 입력이 같지 않으면 관련 유효하지 않은 결과가 리턴`() {
        // given
        val passwordInput = "qwer12345"
        val passwordConfirmInput = "qwer1234"

        // when
        val passwordConfirmResult = PasswordConfirm.from(
            passwordInput,
            passwordConfirmInput
        )

        // then
        passwordConfirmResult shouldBe PasswordConfirmResult.NotSamePasswordConfirm
    }

    @Test
    fun `비밀번호 입력과 비밀번호 확인이 같다면 성공 결과가 리턴`() {
        // given
        val passwordInput = "qwer12345"
        val passwordConfirmInput = "qwer12345"

        // when
        val passwordConfirmResult = PasswordConfirm.from(
            passwordInput,
            passwordConfirmInput
        )

        // then
        passwordConfirmResult shouldBe PasswordConfirmResult.Success(
            PasswordConfirm(passwordConfirmInput)
        )
    }

    @Test
    fun `비밀번호 입력이 길이와 형식이 적절하다면 성공 결과 리턴`() {
        // given & when
        val input = "qwer12345"

        // then
        Password.from(input) shouldBe PasswordResult.Success(Password(input))
    }
}