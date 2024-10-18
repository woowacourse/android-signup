package nextstep.signup.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrowWithMessage
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
}
