package nextstep.signup.domain

import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class UserNameTest {

    @ParameterizedTest
    @ValueSource(strings = ["ab", "abc", "abcd", "abcde"])
    fun `사용자 이름은 2 ~ 5자 이내이어야 한다`(name: String) {
        UserName(name)
    }

    @ParameterizedTest
    @ValueSource(strings = ["a", "오둥오둥오둥"])
    fun `사용자 이름은 2 ~ 5 자가 아니면 예외 발생`(name: String) {
        shouldThrow<IllegalArgumentException> {
            UserName(name)
        }
    }
}
