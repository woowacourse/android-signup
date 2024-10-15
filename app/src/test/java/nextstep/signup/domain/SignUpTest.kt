package nextstep.signup.domain

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

class SignUpTest {

    @Test
    fun `isValid returns true when all fields are valid and passwords match`() {
        val signUp = SignUp(
            email = Email("test@example.com"),
            username = Username("test"),
            password = Password("password123"),
            confirmPassword = Password("password123")
        )

        assertTrue(signUp.isValid())
    }

    @Test
    fun `isValid returns false when email is invalid`() {
        val signUp = SignUp(
            email = Email("invalid-email"),
            username = Username("testuser"),
            password = Password("password123"),
            confirmPassword = Password("password123")
        )

        assertFalse(signUp.isValid())
    }

    @Test
    fun `isValid returns false when username is invalid`() {
        val signUp = SignUp(
            email = Email("test@example.com"),
            username = Username(""),
            password = Password("password123"),
            confirmPassword = Password("password123")
        )

        assertFalse(signUp.isValid())
    }

    @Test
    fun `isValid returns false when passwords do not match`() {
        val signUp = SignUp(
            email = Email("test@example.com"),
            username = Username("testuser"),
            password = Password("password123"),
            confirmPassword = Password("differentPassword")
        )

        assertFalse(signUp.isValid())
    }

    @Test
    fun `errorMessage returns INVALID_CONFIRM_PASSWORD when passwords do not match`() {
        val signUp = SignUp(
            email = Email("test@example.com"),
            username = Username("testuser"),
            password = Password("password123"),
            confirmPassword = Password("differentPassword")
        )

        assertEquals(Error.INVALID_CONFIRM_PASSWORD, signUp.errorMessage())
    }

    @Test
    fun `errorMessage returns null when confirmPassword is blank`() {
        val signUp = SignUp(
            email = Email("test@example.com"),
            username = Username("testuser"),
            password = Password("password123"),
            confirmPassword = Password("")
        )

        assertNull(signUp.errorMessage())
    }

    @Test
    fun `errorMessage returns null when all fields are valid and passwords match`() {
        val signUp = SignUp(
            email = Email("test@example.com"),
            username = Username("test"),
            password = Password("password123"),
            confirmPassword = Password("password123")
        )

        assertNull(signUp.errorMessage())
    }
}
