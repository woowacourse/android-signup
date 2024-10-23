package nextstep.signup.domain

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class UsernameTest {
    @Test
    fun `사용자 이름의 길이가 2자 보다 작으면 유효하지 않다`() {
        // when
        val username = Username("a")

        // then
        assertFalse(username.isValidLength)
    }

    @Test
    fun `사용자 이름의 길이가 5자 보다 크면 유효하지 않다`() {
        // when
        val username = Username("abcdef")

        // then
        assertFalse(username.isValidLength)
    }

    @Test
    fun `사용자 이름에 대소문자가 포함될 수 있다`() {
        // when
        val username = Username("Hodu")

        // then
        assertTrue(username.isValidFormat)
    }

    @Test
    fun `사용자 이름에 한글이 포함될 수 있다`() {
        // when
        val username = Username("호두")

        // then
        assertTrue(username.isValidFormat)
    }

    @Test
    fun `사용자 이름에 공백 문자가 존재하면 유효하지 않다`() {
        // when
        val username = Username("ho du")

        // then
        assertFalse(username.isValidFormat)
    }

    @Test
    fun `사용자 이름에 특수 문자가 존재하면 유효하지 않다`() {
        // when
        val username = Username("ho@du")

        // then
        assertFalse(username.isValidFormat)
    }
}
