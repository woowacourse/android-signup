package nextstep.signup.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.matchers.shouldBe
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

    @ParameterizedTest
    @ValueSource(strings = ["t", "a", "sdfsfeie", "fkskdie"])
    fun `이름 입력이 2자 미만 5자 초과이면 유효하지 않은 길이의 사용자 이름 결과가 리턴된다`(input: String) {
        // given & when
        val userNameResult = UserName.from(input = input)

        // then
        userNameResult shouldBe UserNameResult.InvalidNameLength
    }

    @ParameterizedTest
    @ValueSource(strings = ["11", "a1", "2sf", "0sd9", "++", "-_", "$5", "^tt^"])
    fun `이름 입력에 숫자 혹은 기호가 들어가면 유효하지 않은 형식의 사용자 이름 결과가 리턴된다`(input: String) {
        // given & when
        val userNameResult = UserName.from(input = input)

        // then
        userNameResult shouldBe UserNameResult.InvalidNameFormat
    }

    @ParameterizedTest
    @ValueSource(strings = ["ab", "abc", "sdfs", "sdfsf"])
    fun `이름 입력에 2자 이상 5자 이하이며 이름에 기호와 숫자가 들어가지 않으면 성공 사용자 이름 결과가 리턴된다`(input: String) {
        // given & when
        val userNameResult = UserName.from(input = input)

        // then
        userNameResult shouldBe UserNameResult.Success(UserName(input))
    }
}
