package nextstep.signup.model

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class EmailTest {
    @Test
    fun `이메일은 유효한 패턴을 갖는다`() {
        val email = Email("test@example.com")

        assertTrue(email.isValid())
    }

    @Test
    fun `이메일에 @가 없는 경우, 유효하지 않다`() {
        val email = Email("testexample.com")

        assertFalse(email.isValid())
    }

    @Test
    fun `이메일에 도메인이 없는 경우, 유효하지 않다`() {
        val email = Email("test@")

        assertFalse(email.isValid())
    }

    @Test
    fun `이메일에 확장자가 없는 경우, 유효하지 않다`() {
        val email = Email("test@example")

        assertFalse(email.isValid())
    }

    @Test
    fun `이메일에 특수문자가 잘못 포함된 경우, 유효하지 않다`() {
        val email = Email("test@ex!ample.com")

        assertFalse(email.isValid())
    }
}
