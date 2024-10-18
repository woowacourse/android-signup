package nextstep.signup.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class EmailTest {
    @Test
    fun `이메일 형식에 맞도록 입력한 경우 유효하다`() {
        shouldNotThrow<IllegalArgumentException> {
            Email("sh1mj1@wooteco.com")
        }
    }

    @Test
    fun `이메일 입력에 @가 없으면 유효하지 않다`() {
        shouldThrowWithMessage<IllegalArgumentException>(message = "the email format is not correct") {
            Email("sh1mj1")
        }
    }

    @Test
    fun `이메일 입력 @ 뒤에 점이 없으며 유효하지 않다`() {
        shouldThrowWithMessage<IllegalArgumentException>(message = "the email format is not correct") {
            Email("sh1mj1@wootecocom")
        }
    }

    @Test
    fun `입력이 이메일 형식에 맞는 경우 성공 이메일 결과가 리턴된다`() {
        // given & when
        val input = "sh1mj1@wooteco.com"
        val emailResult = Email.from(input = input)

        // then
        emailResult shouldBe EmailResult.Success(Email(input))
    }

    @Test
    fun `입력이 공백인 경우 공백 이메일 결과가 리턴된다`() {
        // given & when
        val emailResult = Email.from(input = "")

        // then
        emailResult shouldBe EmailResult.EmptyField
    }

    @Test
    fun `입력이 이메일 형식에 맞지 않은 경우 유효하지 않은 형식의 이메일 결과가 리턴된다`() {
        // given & when
        val emailResult = Email.from(input = "aa")

        // then
        emailResult shouldBe EmailResult.InvalidNameFormat
    }
}
