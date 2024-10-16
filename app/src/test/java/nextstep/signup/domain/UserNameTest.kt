package nextstep.signup.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrowWithMessage
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class UserNameTest {
    @ParameterizedTest
    @ValueSource(strings = ["t", "a", "sdfsfeie", "fkskdie"])
    fun `이름의 길이가 2자 미만 5자 초과이면 유효하지 않다`(name: String) {
        shouldThrowWithMessage<IllegalArgumentException>(message = "name has to be in 2..5") {
            UserName(name)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["11", "a1", "2sf", "0sd9"])
    fun `이름에 숫자가 들어가면 유효하지 않다`(name: String) {
        shouldThrowWithMessage<IllegalArgumentException>(message = "name must not include number or symbol") {
            UserName(name)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["++", "-_", "$5", "^tt^"])
    fun `이름에 기호가 들어가면 유효하지 않다`(name: String) {
        shouldThrowWithMessage<IllegalArgumentException>(message = "name must not include number or symbol") {
            UserName(name)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["ab", "abc", "sdfs", "sdfsf"])
    fun `이름의 길이가 2자 이상 5자 이하이며 이름에 기호와 숫자가 들어가지 않으면 유효하다`(name: String) {
        shouldNotThrow<IllegalArgumentException> {
            UserName(name)
        }
    }
}
