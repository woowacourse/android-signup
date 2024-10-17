package nextstep.signup.model

import nextstep.signup.ui.model.Email
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class EmailTest {
    private val invalidPatternErrorMessage = "이메일 형식이 올바르지 않습니다."

    @Test
    fun `이메일이 유효한 패턴을 만족하는 경우 에러가 발생하지 않는다`() {
        val validEmail = Email("test@example.com")

        assertTrue(validEmail.isValid())
        assertEquals("", validEmail.errorMessage())
    }

    @Test
    fun `이메일에 @가 없는 경우 에러가 발생한다`() {
        val invalidEmail = Email("testexample.com")

        assertFalse(invalidEmail.isValid())
        assertEquals(invalidPatternErrorMessage, invalidEmail.errorMessage())
    }

    @Test
    fun `이메일에 도메인이 없는 경우 에러가 발생한다`() {
        val invalidEmail = Email("test@")

        assertFalse(invalidEmail.isValid())
        assertEquals(invalidPatternErrorMessage, invalidEmail.errorMessage())
    }

    @Test
    fun `이메일에 확장자가 없는 경우 에러가 발생한다`() {
        val invalidEmail = Email("test@example")

        assertFalse(invalidEmail.isValid())
        assertEquals(invalidPatternErrorMessage, invalidEmail.errorMessage())
    }

    @Test
    fun `이메일에 특수문자가 잘못 포함된 경우 에러가 발생한다`() {
        val invalidEmail = Email("test@ex!ample.com")

        assertFalse(invalidEmail.isValid())
        assertEquals(invalidPatternErrorMessage, invalidEmail.errorMessage())
    }
}
