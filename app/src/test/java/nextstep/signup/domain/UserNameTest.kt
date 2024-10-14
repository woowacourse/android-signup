package nextstep.signup.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class UserNameTest {
    @Test
    fun `유효하지 않은 유저 네임`() {
        // given
        val userName = UserName("")

        // then
        userName.isValid() shouldBe false
    }

    @Test
    fun `유효한 유저 네임`() {
        // given
        val userName = UserName("ss")

        // then
        userName.isValid() shouldBe true
    }
}
