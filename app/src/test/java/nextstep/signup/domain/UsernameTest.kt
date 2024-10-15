package nextstep.signup.domain

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class UsernameTest {

    @Test
    fun `Username with length 2 name value is valid()`() {
        val username = Username("ab")

        assertTrue(username.isValid())
    }

    @Test
    fun `Username with length 1 name value is invalid()`() {
        val username = Username("a")

        assertFalse(username.isValid())
    }

    @Test
    fun `Username with length 6 name value is invalid()`() {
        val username = Username("abcdef")

        assertFalse(username.isValid())
    }

    @Test
    fun `Username with number is invalid()`() {
        val username = Username("abc1")

        assertFalse(username.isValid())
    }

    @Test
    fun `Username with special character is invalid()`() {
        val username = Username("abc!")

        assertFalse(username.isValid())
    }
}
