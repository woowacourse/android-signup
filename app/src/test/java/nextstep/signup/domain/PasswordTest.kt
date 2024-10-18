package nextstep.signup.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class PasswordTest {
    @Test
    fun `비밀번호 입력이 공백이면 공백 비밀번호 결과가 리턴`() {
        // given & when
        val input = ""

        // then
        Password.from(input) shouldBe PasswordResult.EmptyField
    }

    @Test
    fun `비밀번호 입력이 8자 미만이거나 16자 초과이면 유효하지 않은 길이 결과가 리턴`() {
        // given & when
        val input = "sdf123"

        // then
        Password.from(input) shouldBe PasswordResult.InvalidPasswordLength
    }

    @Test
    fun `비밀번호 입력이 최소한 숫자 하나와 문자 영문자 하나를 포함하지 않는다면 유효하지 않은 형식 결과가 리턴`() {
        // given & when
        val input = "kskdjsjdhfi"

        // then
        Password.from(input) shouldBe PasswordResult.InvalidPasswordFormat
    }

    @Test
    fun `비밀번호 입력이 길이와 형식이 적절하다면 성공 결과 리턴`() {
        // given & when
        val input = "qwer12345"

        // then
        Password.from(input) shouldBe PasswordResult.Success(Password(input))
    }
}
