package woowacourse.signup.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class UserNameTest {
    @Test
    fun `형식에 맞는 이름을 생성하면 예외가 발생하지 않는다`() {
        assertDoesNotThrow {
            UserName("올리브")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["헷", "올리브는짱이다"])
    fun `이름의 길이가 2~5자가 아니라면 예외가 발생한다`(userNameValue: String) {
        assertThrows<InvalidUserNameLengthException> {
            UserName(userNameValue)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["올리브1", "올리브!"])
    fun `이름에 숫자나 기호가 포함되면 예외가 발생한다`(userNameValue: String) {
        assertThrows<InvalidUserNameCompositionException> {
            UserName(userNameValue)
        }
    }
}
