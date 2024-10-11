package nextstep.signup.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class PasswordTest {
    @Test
    fun `공백이면 유효하지 않은 패스워드`() {
        // given
        val password = Password(
            password = "",
            passwordConfirm = ""
        )

        // then
        password.isValid() shouldBe false
    }

    @Test
    fun `공백이 아니고 비번과 비번 확인이 같다`() {
        // given
        val password = Password(
            password = "123",
            passwordConfirm = "123"
        )

        // then
        password.isValid() shouldBe true
    }
}
