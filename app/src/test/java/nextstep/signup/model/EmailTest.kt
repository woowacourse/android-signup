package nextstep.signup.model

import org.junit.Assert.assertEquals
import org.junit.Test

class EmailTest {
    @Test
    fun `이메일 형식에 @가 포함되어 있지 않다면 에러메시지가 반환된다`() {
        val errorMessage: String? = Email("hannahnaver.com").getErrorMessage()
        assertEquals(EMAIL_FORM_ERROR, errorMessage)
    }

    @Test
    fun `이메일 형식에 온점이 포함되어 있지 않다면 에러메시지가 반환된다`() {
        val errorMessage: String? = Email("hannah@navercom").getErrorMessage()
        assertEquals(EMAIL_FORM_ERROR, errorMessage)
    }

    @Test
    fun `이메일 형식에 @와 온점을 포함되어 있지 않으면 에러메시지가 반환된다`() {
        val errorMessage: String? = Email("hannahnavercom").getErrorMessage()
        assertEquals(EMAIL_FORM_ERROR, errorMessage)
    }

    @Test
    fun `이메일 형식이 올바르면 에러메시지는 null이 반환된다`() {
        val errorMessage: String? = Email("hannah@naver.com").getErrorMessage()
        assertEquals(null, errorMessage)
    }

    @Test
    fun `이메일_형식이_비어있다면_isInvalid의_값은_false이다`() {
        val isInvalid: Boolean = Email("").isInvalid()
        assertEquals(false, isInvalid)
    }

    companion object {
        private const val EMAIL_FORM_ERROR = "이메일 형식이 올바르지 않습니다."
    }
}
