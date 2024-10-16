package nextstep.signup.domain

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PasswordTest {
    @ParameterizedTest
    @ValueSource(strings = ["t", "1", "123", "fm298"])
    fun `패스워드의 길이가 8자 미만이면 유효하지 않다`(password: String) {
        shouldThrowWithMessage<IllegalArgumentException>(message = "password has to be in 8..16") {
            Password(password = password)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["148jmdshfi289sdf9", "118283487591345123", "dsfkjshfi2y834234"])
    fun `패스워드의 길이가 16자 초과이면 유효하지 않다`(password: String) {
        shouldThrowWithMessage<IllegalArgumentException>(message = "password has to be in 8..16") {
            Password(password = password)
        }
    }


}
