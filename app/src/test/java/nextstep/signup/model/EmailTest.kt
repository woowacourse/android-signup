package nextstep.signup.model

import org.junit.Assert.assertEquals
import org.junit.Test

class EmailTest {
    @Test
    fun `이메일_형식이_올바르면_에러메시지는_null이_반환된다`() {
        val errorMessage: String? = Email("hannah@naver.com").getErrorMessage()
        assertEquals(null, errorMessage)
    }

    @Test
    fun `이메일_형식이_올바르면_에러메시지가_반환된다`() {
        val errorMessage: String? = Email("hannah@naver.com").getErrorMessage()
        assertEquals(EMAIL_FORM_ERROR, errorMessage)
    }

//    @Test
//    fun

    companion object {
        private const val EMAIL_FORM_ERROR = "이메일 형식이 올바르지 않습니다."
    }
}