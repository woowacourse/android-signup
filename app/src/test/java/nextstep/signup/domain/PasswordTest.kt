package nextstep.signup.domain

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class PasswordTest {

    @Test
    fun `valid when contains eng and number and length is between 8-16`() {
        // given
        val password = Password("Abcdef1234!")

        // when
        val result = password.isValid()

        // then
        assertTrue(result)
    }

    @Test
    fun `invalid when empty`() {
        // given
        val password = Password("")

        // when
        val result = password.isValid()

        // then
        assertFalse(result)
    }

    @Test
    fun `invalid when length is shorter than 8`() {
        // given
        var password = Password("a")

        // when & then
        repeat(6) {
            password = password.copy(value = password.value + "1")
            val result = password.isValid()
            assertFalse(result)
        }
    }

    @Test
    fun `invalid when length is longer than 16`() {
        // given
        // length is 17
        val password = Password("abcdefg1234567891")

        // when
        val result = password.isValid()

        // then
        assertFalse(result)
    }

    @Test
    fun `invalid when eng and number both contained`() {
        // given
        val password1 = Password("abcdefghi")
        val password2 = Password("12345678")

        // when
        val result1 = password1.isValid()
        val result2 = password2.isValid()

        // then
        assertFalse(result1)
        assertFalse(result2)
    }

    @Test
    fun `errorMessage is null when value is blank`() {
        // given
        val password = Password("")

        // when
        val error = password.errorMessage()

        // then
        assertNull(error)
    }

    @Test
    fun `errorMessage is null when valid`() {
        // given
        val password = Password("Abcdef1234!")

        // when
        val error = password.errorMessage()

        // then
        assertNull(error)
    }

    @Test
    fun `errorMessage is INVALID_PASSWORD_LENGTH when length is shorter than 8`() {
        // given
        var password = Password("a")

        // when & then
        repeat(6) {
            password = password.copy(value = password.value + "1")
            val error = password.errorMessage()
            assertEquals(Error.INVALID_PASSWORD_LENGTH, error)
        }
    }

    @Test
    fun `errorMessage is INVALID_PASSWORD_LENGTH when length is longer than 16`() {
        // given
        val password = Password("1abcdefghijklmnopqrstuvwxyz")

        // when
        val error = password.errorMessage()

        // then
        assertEquals(Error.INVALID_PASSWORD_LENGTH, error)
    }

    @Test
    fun `errorMessage is INVALID_PASSWORD_TYPE when eng and number both contained`() {
        // given
        val password1 = Password("abcdefghi")
        val password2 = Password("12345678")

        // when
        val error1 = password1.errorMessage()
        val error2 = password2.errorMessage()

        // then
        assertEquals(Error.INVALID_PASSWORD_TYPE, error1)
        assertEquals(Error.INVALID_PASSWORD_TYPE, error2)
    }
}
