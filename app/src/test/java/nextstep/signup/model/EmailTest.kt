package nextstep.signup.model

import org.junit.Assert.assertEquals
import org.junit.Test

class EmailTest {
    @Test
    fun `이메일 형식에 @가 포함되어 있지 않다면 EmailValidResult는 InvalidForm이 반환된다`() {
        val emailValidResult: EmailValidResult = Email("hannahnaver.com").validate()
        assertEquals(EmailValidResult.InvalidForm, emailValidResult)
    }

    @Test
    fun `이메일 형식에 온점이 포함되어 있지 않다면 EmailValidResult는 InvalidForm이 반환된다`() {
        val emailValidResult: EmailValidResult = Email("hannah@navercom").validate()
        assertEquals(EmailValidResult.InvalidForm, emailValidResult)
    }

    @Test
    fun `이메일 형식에 @와 온점을 포함되어 있지 않으면 EmailValidResult는 InvalidForm이 반환된다`() {
        val emailValidResult: EmailValidResult = Email("hannahnavercom").validate()
        assertEquals(EmailValidResult.InvalidForm, emailValidResult)
    }

    @Test
    fun `이메일 형식이 올바르면 EmailValidResult는 Success가 반환된다`() {
        val emailValidResult: EmailValidResult = Email("hannah@naver.com").validate()
        assertEquals(EmailValidResult.Success, emailValidResult)
    }

    @Test
    fun `이메일_형식이_비어있다면_isError의_값은_false이다`() {
        val isError: Boolean = Email("").isError()
        assertEquals(false, isError)
    }

    @Test
    fun `이메일_형식이_올바르다면_isValid의_값은_true이다`() {
        val isValid: Boolean = Email("hannah@naver.com").isValid()
        assertEquals(true, isValid)
    }

    @Test
    fun `이메일 형식이 올바르지 않다면 isValid의 값은 true이다`() {
        val isValid: Boolean = Email("hannahnavercom").isValid()
        assertEquals(false, isValid)
    }
}
