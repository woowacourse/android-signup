package nextstep.signup.domain

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class EmailTest {
    @Test
    fun `Email with id and domain is valid`() {
        val email = Email("aaa@naver.com")

        assertTrue(email.isValid())
    }

    @Test
    fun `Email without @ is invalid`() {
        val email = Email("aaa.naver.com")

        assertFalse(email.isValid())
    }

    @Test
    fun `Email without domain is invalid`() {
        val email1 = Email("aaa")
        val email2 = Email("aaa@")

        assertFalse(email1.isValid())
        assertFalse(email2.isValid())
    }

    @Test
    fun `Email without id is invalid`() {
        val email = Email("@naver.com")

        assertFalse(email.isValid())
    }

    @Test
    fun `Email without id and domain is invalid`() {
        val email = Email("@")

        assertFalse(email.isValid())
    }

    @Test
    fun `Email with invalid domain is invalid (nothing after dot)`() {
        val email = Email("aaa@naver.")

        assertFalse(email.isValid())
    }

    @Test
    fun `Email with invalid domain is invalid (one letter after dot)`() {
        val email = Email("aaa@naver.c")

        assertFalse(email.isValid())
    }
}
