package nextstep.signup.ui.model

import org.junit.Assert.*
import org.junit.Test

class SignUpFormStateTest {
    @Test
    fun emptyUsername_returnsEmptyStatus() {
        // given & when
        val formState = SignUpFormState(username = "")

        // then
        assertEquals(SignUpStatus.Empty, formState.usernameStatus)
    }

    @Test
    fun invalidUsername_invalidLength_returnsUsernameLengthErrorStatus() {
        // given & when
        val invalidUsernames = listOf("a", "abcdef")
        invalidUsernames.forEach { username ->
            val formState = SignUpFormState(username = username)

            // then
            assertEquals(SignUpStatus.Error.UsernameLength, formState.usernameStatus)
        }
    }

    @Test
    fun invalidUsername_containsNumberSign_returnsUsernameNonCharacterErrorStatus() {
        // given & when
        val invalidUsernames = listOf("abcd1", "abcd#", "ab1#")
        invalidUsernames.forEach { username ->
            val formState = SignUpFormState(username = username)

            // then
            assertEquals(SignUpStatus.Error.UsernameNonCharacter, formState.usernameStatus)
        }
    }

    @Test
    fun validUsername_returnsSuccessStatus() {
        // given & when
        val formState = SignUpFormState(username = "abcde")

        // then
        assertEquals(SignUpStatus.Success, formState.usernameStatus)
    }

    @Test
    fun emptyEmail_returnsEmptyStatus() {
        // given & when
        val formState = SignUpFormState(email = "")

        // then
        assertEquals(SignUpStatus.Empty, formState.emailStatus)
    }

    @Test
    fun invalidEmail_inappropriateForm_returnsEmailFormatErrorStatus() {
        // given & when
        val invalidEmails = listOf("kmkim", "kmkim@", "kmkim@kr", "kmkim@kr.")
        invalidEmails.forEach { username ->
            val formState = SignUpFormState(email = username)

            // then
            assertEquals(SignUpStatus.Error.EmailFormat, formState.emailStatus)
        }
    }

    @Test
    fun validEmail_returnsSuccessStatus() {
        // given & when
        val formState = SignUpFormState(email = "kmkim@gmail.com")

        // then
        assertEquals(SignUpStatus.Success, formState.emailStatus)
    }

    @Test
    fun emptyPassword_returnsEmptyStatus() {
        // given & when
        val formState = SignUpFormState(password = "")

        // then
        assertEquals(SignUpStatus.Empty, formState.passwordStatus)
    }

    @Test
    fun invalidPassword_invalidLength_returnsPasswordLengthErrorStatus() {
        // given & when
        val invalidPasswords = listOf("1234567", "12345678901234567")

        invalidPasswords.forEach { password ->
            val formState = SignUpFormState(password = password)

            // then
            assertEquals(SignUpStatus.Error.PasswordLength, formState.passwordStatus)
        }
    }

    @Test
    fun invalidPassword_containsNoAlphabetNumber_returnsPasswordFormatErrorStatus() {
        // given & when
        val invalidPasswords = listOf("12345678", "abcdefgh", "!@#!@#!@")
        invalidPasswords.forEach { password ->
            val formState = SignUpFormState(password = password)

            // then
            assertEquals(SignUpStatus.Error.PasswordFormat, formState.passwordStatus)
        }
    }

    @Test
    fun validPassword_returnsSuccessStatus() {
        // given & when
        val formState = SignUpFormState(password = "abcd1234")

        // then
        assertEquals(SignUpStatus.Success, formState.passwordStatus)
    }

    @Test
    fun emptyPasswordConfirmation_returnsEmptyStatus() {
        // given & when
        val formState = SignUpFormState(passwordConfirmation = "")

        // then
        assertEquals(SignUpStatus.Empty, formState.passwordConfirmationStatus)
    }

    @Test
    fun passwordConfirmation_notEqualPassword_returnsPasswordConfirmationErrorStatus() {
        // given & when
        val formState = SignUpFormState(password = "abcd1234", passwordConfirmation = "abcd1235")

        // then
        assertEquals(SignUpStatus.Error.PasswordConfirmation, formState.passwordConfirmationStatus)
    }

    @Test
    fun validPasswordConfirmation_returnsSuccessStatus() {
        // given & when
        val formState = SignUpFormState(password = "abcd1234", passwordConfirmation = "abcd1234")

        // then
        assertEquals(SignUpStatus.Success, formState.passwordConfirmationStatus)
    }

    @Test
    fun formValid_allValid_returnsTrue() {
        // given & when
        val formState = SignUpFormState(
            username = "abcde",
            email = "kmkim@pengcook.com",
            password = "abcd1234",
            passwordConfirmation = "abcd1234"
        )

        val result = formState.formValid

        // then
        assertTrue(result)
    }

    @Test
    fun formValid_notAllValid_returnsFalse() {
        // given & when
        val formState = SignUpFormState(
            username = "abcde",
            email = "kmkim@pengcook.com",
            password = "abcd1234",
            passwordConfirmation = "abcd1235"
        )

        val result = formState.formValid

        // then
        assertFalse(result)
    }
}
