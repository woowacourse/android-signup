package nextstep.signup.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.types.shouldBeTypeOf
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.Test

class PasswordTest {

    @Test
    fun `비밀번호가 공백이면 예외 발생`() {
        shouldThrow<IllegalArgumentException> {
            Password(" ")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["Valid123!", "StrongPass1!", "StrongPass1"])
    fun `비밀번호는 영문, 숫자 조합 8 ~ 16 자리`(password: String) {
        Password(password)
    }

    @ParameterizedTest
    @ValueSource(strings = ["Valid123!", "Passw0rd!"])
    fun `비밀번호는 영문, 숫자 조합 8 ~ 16 자리 만족하는 경우 성공 반환`(password: String) {
        Password.validate(password).shouldBeTypeOf<PasswordValidateResult.Success>()
    }

    @ParameterizedTest
    @ValueSource(strings = ["password", "Pass0rd", "Passw@rd", "12345678", "abcd!@#$"])
    fun `비밀번호는 영문, 숫자 조합 8 ~ 16 자리가 아니면 예외 발생`(password: String) {
        shouldThrow<IllegalArgumentException> {
            Password(password)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["ValidPass!", "NoNumberPass!"])
    fun `숫자가 없으면 유효하지 않음`(password: String) {
        Password.validate(password).shouldBeTypeOf<PasswordValidateResult.InValidNotContainNumber>()
    }

    @ParameterizedTest
    @ValueSource(strings = ["하이@3211", "1234123!"])
    fun `영어 없으면 유효하지 않음`(password: String) {
        Password.validate(password).shouldBeTypeOf<PasswordValidateResult.InValidNotContainAlpha>()
    }

    @ParameterizedTest
    @ValueSource(strings = ["short1@", "longpasswordtoolong123!"])
    fun `8 ~ 16 길이가 이니면 유효하지 않음`(password: String) {
        Password.validate(password).shouldBeTypeOf<PasswordValidateResult.InValidNotInLength>()
    }
}
