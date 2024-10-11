package nextstep.signup.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class EmailTest {
    @Test
    fun `유효하지 않은 이메일 아이디`() {
        // given
        val mailId = EmailId("")

        // then
        mailId.isValid() shouldBe false
    }

    @Test
    fun `유효하지 않은 이메일 도메인`() {
        // given
        val mailDomain = EmailDomain("")

        // then
        mailDomain.isValid() shouldBe false
    }

    @Test
    fun `유효한 이메일`() {
        // given
        val email = Email(
            id = EmailId("악어"),
            domain = EmailDomain("wooteco.com")
        )

        // then
        email.isValid() shouldBe true
    }
}
