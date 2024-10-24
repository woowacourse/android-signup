package nextstep.signup.model

import org.junit.Assert.assertEquals
import org.junit.Test

class EmailTest {
    @Test
    fun `이메일 형식에 @가 포함되어 있지 않다면 형식 유효성 검증에 실패한다`() {
        val emailValidResult: EmailValidResult = Email("hannahnaver.com").validate()
        assertEquals(EmailValidResult.InvalidForm, emailValidResult)
    }

    @Test
    fun `이메일 형식에 온점이 포함되어 있지 않다면 형식 유효성 검증에 실패한다`() {
        val emailValidResult: EmailValidResult = Email("hannah@navercom").validate()
        assertEquals(EmailValidResult.InvalidForm, emailValidResult)
    }

    @Test
    fun `이메일 형식에 @와 온점을 포함되어 있지 않으면 형식 유효성 검증에 실패한다`() {
        val emailValidResult: EmailValidResult = Email("hannahnavercom").validate()
        assertEquals(EmailValidResult.InvalidForm, emailValidResult)
    }

    @Test
    fun `이메일 형식이 올바르면 형식 유효성 검증에 성공한다`() {
        val emailValidResult: EmailValidResult = Email("hannah@naver.com").validate()
        assertEquals(EmailValidResult.Success, emailValidResult)
    }

    @Test
    fun `이메일 형식이 비어있는 상태는 오류가 아니다`() {
        val isError: Boolean = Email("").isError()
        assertEquals(false, isError)
    }

    @Test
    fun `이메일 형식이 @와 도메인을 포함하고 있다면 유효하다`() {
        val isValid: Boolean = Email("hannah@naver.com").isValid()
        assertEquals(true, isValid)
    }

    @Test
    fun `이메일 형식이 @와 도메인을 포함하고 있지 않다면 유효하지 않다`() {
        val isValid: Boolean = Email("hannahnavercom").isValid()
        assertEquals(false, isValid)
    }
}
