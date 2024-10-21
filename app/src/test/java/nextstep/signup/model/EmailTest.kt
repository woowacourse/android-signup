package nextstep.signup.model

import nextstep.signup.domain.Email
import nextstep.signup.domain.ErrorCode
import org.junit.Assert
import org.junit.Test

class EmailTest {
    @Test
    fun `이메일 값이 비어있을 때 유효성 검사가 성공적으로 통과된다`() {
        // given
        val email = Email("")

        // when
        val result = email.validate()

        // then
        Assert.assertFalse(result.isError)
    }

    @Test
    fun `올바른 형식의 이메일일 경우 유효성 검사가 성공적으로 통과된다`() {
        // given
        val email = Email("test@example.com")

        // when
        val result = email.validate()

        // then
        Assert.assertFalse(result.isError)
    }

    @Test
    fun `잘못된 형식의 이메일일 경우 유효성 검사가 실패한다`() {
        // given
        val email = Email("test")

        // when
        val result = email.validate()

        // then
        Assert.assertTrue(result.isError)
        Assert.assertEquals(result.errorCode, ErrorCode.ERROR_INVALID_EMAIL_FORMAT)
    }

    @Test
    fun `도메인이 없는 이메일일 경우 유효성 검사가 실패한다`() {
        // given
        val email = Email("test@")

        // when
        val result = email.validate()

        // then
        Assert.assertTrue(result.isError)
        Assert.assertEquals(result.errorCode, ErrorCode.ERROR_INVALID_EMAIL_FORMAT)
    }

    @Test
    fun `이메일에 특수 문자가 올바르게 포함된 경우 유효성 검사가 성공적으로 통과된다`() {
        // given
        val email = Email("test.user+alias@example.com")

        // when
        val result = email.validate()

        // then
        Assert.assertFalse(result.isError)
    }
}
