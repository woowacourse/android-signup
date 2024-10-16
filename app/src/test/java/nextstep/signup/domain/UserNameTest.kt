package nextstep.signup.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.assertions.throwables.shouldThrowWithMessage
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class UserNameTest {
    @ParameterizedTest
    @ValueSource(strings = ["12", "abc", "sdfs", "sdfsf"])
    fun `이름의 길이가 2자 이상 5자 이하이면 유효하다`(name: String) {
        shouldNotThrow<IllegalArgumentException> {
            UserName(name)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "a", "sdfsfeie", "fkskdie"])
    fun `이름의 길이가 2자 미만 5자 초과이면 유효 하지 않다`(name: String) {
        shouldThrow<IllegalArgumentException> {
            UserName(name)
        }
        shouldThrowWithMessage<IllegalArgumentException>(message = "name has to be in 2..5") {
            UserName(name)
        }
    }
}
