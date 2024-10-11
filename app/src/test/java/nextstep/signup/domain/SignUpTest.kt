package nextstep.signup.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class SignUpTest {
    @Test
    fun `유효한 회원가입 `() {
        // given
        val userName = UserName(name = "심지")
        val mail = Email(
            id = EmailId("악어"),
            domain = EmailDomain("wooteco.com")
        )
        val password = Password(
            password = "qwer",
            passwordConfirm = "qwer"
        )
        val signUp = SignUp(
            userName,
            mail,
            password
        )

        // then
        signUp.isValid() shouldBe true
    }
}
