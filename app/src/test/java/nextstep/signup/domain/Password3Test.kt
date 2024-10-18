package nextstep.signup.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrowWithMessage
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class Password3Test {
    @ParameterizedTest
    @ValueSource(strings = ["t", "1", "123", "fm298"])
    fun `패스워드의 길이가 8자 미만이면 유효하지 않다`(password: String) {
        shouldThrowWithMessage<IllegalArgumentException>(message = "password has to be in 8..16") {
            Password3(password = password)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["148jmdshfi289sdf9", "118283487591345123", "dsfkjshfi2y834234"])
    fun `패스워드의 길이가 16자 초과이면 유효하지 않다`(password: String) {
        shouldThrowWithMessage<IllegalArgumentException>(message = "password has to be in 8..16") {
            Password3(password = password)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["012345678", "876543210"])
    fun `패스워드가 숫자를 포함하지 않으면 유효하지 않다`(password: String) {
        shouldThrowWithMessage<IllegalArgumentException>(message = "password must contain at least one English and number") {
            Password3(password = password)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["abcdefghi", "jklmnopqrset"])
    fun `패스워드가 영문을 포함하지 않으면 유효하지 않다`(password: String) {
        shouldThrowWithMessage<IllegalArgumentException>(message = "password must contain at least one English and number") {
            Password3(password = password)
        }
    }

    @Test
    fun `패스워드와 패스워드 확인이 일치하지 않으면 유효하지 않다`() {
        // given
        val password = "1abcd12345"
        val passwordConfirm = "abcd54321"

        // then
        shouldThrowWithMessage<IllegalArgumentException>(message = "password and password confirm is different") {
            Password3(
                password = password,
                passwordConfirm = passwordConfirm
            )
        }
    }

    @Test
    fun `패스워드가 8~16 자이며 하나 이상의 영문과 숫자를 포함하며 패스워드 확인과 일치하면 유효하다`() {
        // given
        val password = "abcd12345"
        val passwordConfirm = "abcd12345"

        // then
        shouldNotThrow<IllegalArgumentException> {
            Password3(
                password = password,
                passwordConfirm = passwordConfirm
            )
        }
    }
}
