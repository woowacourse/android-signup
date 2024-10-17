package nextstep.signup.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.types.shouldBeTypeOf
import kotlin.test.Test

class PasswordConfirmTest {

    @Test
    fun `비밀번호와 일치해야한다`() {
        // given
        val password = "password"
        val confirmPassword = "password"

        // when & then
        PasswordConfirm(password, confirmPassword)
    }

    @Test
    fun `비밀번호와 일치 결과 성공`() {
        // given
        val password = "password"
        val confirmPassword = "password"

        // when
        val passwordConfirm = PasswordConfirm.validate(password, confirmPassword)

        // then
        passwordConfirm.shouldBeTypeOf<PasswordConfirmValidateResult.Success>()
    }

    @Test
    fun `비밀번호와 일치하지 않으면 예외`() {
        // given
        val password = "password"
        val confirmPassword = "password1"

        // when & then
        shouldThrow<IllegalArgumentException> {
            PasswordConfirm(password, confirmPassword)
        }
    }

    @Test
    fun `비밀번호와 일치하지 않으면 실패 결과 반환`() {
        // given
        val password = "password"
        val confirmPassword = "password1"

        // when
        val passwordConfirm = PasswordConfirm.validate(password, confirmPassword)

        // then
        passwordConfirm.shouldBeTypeOf<PasswordConfirmValidateResult.InValid>()
    }
}