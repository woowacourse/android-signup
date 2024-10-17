package nextstep.signup.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.types.shouldBeTypeOf
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.Test

class EmailTest {

    @Test
    fun `이메일 생성`() {
        Email("test@example.com")
        Email("user@domain.org")
        Email("my.email@domain.co")
    }

    @Test
    fun `이메일은 공백일 수 없다`() {
        shouldThrow<IllegalArgumentException> {
            Email("  ")
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["testexample.com", "user@domainorg", "myemaildomain.co"])
    fun `이메일 형식에 맞지 않으면 예외`(value: String) {
        shouldThrow<IllegalArgumentException> {
            Email(value)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["test@example.com", "user@domain.org", "my.email@domain.co"])
    fun `이메일 결과 생성`(validEmail: String) {
        Email.validate(validEmail).shouldBeTypeOf<EmailValidateResult.Success>()
    }

    @ParameterizedTest
    @ValueSource(strings = ["testexample.com", "user@domainorg", "myemaildomain.co"])
    fun `이메일 양식에 맞지 않으면 유효하지 않은 결과 반환`(invalidEmail: String) {
        Email.validate(invalidEmail).shouldBeTypeOf<EmailValidateResult.InvalidEmailFormat>()
    }
}
