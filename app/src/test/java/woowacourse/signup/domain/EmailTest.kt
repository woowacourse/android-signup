package woowacourse.signup.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class EmailTest {
    @Test
    fun `형식에 맞는 이메일을 생성하면 예외가 발생하지 않는다`() {
        assertDoesNotThrow {
            Email("abc123@wooteco.com")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["123", "abc123@ccc", "abc123.ccc"])
    fun `형식에 맞지 않는 이메일을 생성하면 예외가 발생한다`(emailValue: String) {
        assertThrows<InvalidEmailException> {
            Email(emailValue)
        }
    }
}
