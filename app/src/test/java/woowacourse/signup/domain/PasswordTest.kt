package woowacourse.signup.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class PasswordTest {
    @Test
    fun `형식에 맞는 비밀번호를 생성하면 예외가 발생하지 않는다`() {
        assertDoesNotThrow {
            Password("olive123")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["abc123", "oliveolive1234567890"])
    fun `비밀번호의 길이가 8~16자가 아니라면 예외가 발생한다`(passwordValue: String) {
        assertThrows<InvalidPasswordLengthException> {
            Password(passwordValue)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["oliveolive", "1234567890"])
    fun `비밀번호에 영문과 숫자가 포함되지 않으면 예외가 발생한다`(passwordValue: String) {
        assertThrows<InvalidPasswordCompositionException> {
            Password(passwordValue)
        }
    }
}
