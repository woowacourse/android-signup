package nextstep.signup.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SignUpTest {
    @Test
    fun `유효한 회원가입 `() {
        // given
        val userNameInput = "qwer"
        val emailInput = "qwer@wooteco.com"
        val passwordInput = "qwer12345"
        val passwordConfirmInput = "qwer12345"

        // when
        val signUpResult = SignUp.from(
            userName = UserName.from(userNameInput),
            email = Email.from(emailInput),
            password = Password.from(passwordInput),
            passwordConfirm = PasswordConfirm.from(
                passwordInput,
                passwordConfirmInput,
            )
        )

        // then
        signUpResult shouldBe SignUpResult.Success(
            SignUp(
                userName = UserName(userNameInput),
                email = Email(emailInput),
                password = Password(passwordInput),
                passwordConfirm = PasswordConfirm(passwordConfirmInput)
            )
        )

    }
}
