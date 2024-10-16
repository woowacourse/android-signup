package nextstep.signup.ui.model

import nextstep.signup.R
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class UserFormTest {
    @Test
    fun emptyUsername_returnsEmptyStatus() {
        // given & when
        val formState = UserForm(username = "")

        // then
        assertEquals(SignUpStatus.Empty, formState.usernameStatus)
    }

    @Test
    fun invalidUsername_invalidLength_returnsUsernameLengthErrorStatus() {
        // given & when
        val invalidUsernames = listOf("a", "abcdef")
        invalidUsernames.forEach { username ->
            val formState = UserForm(username = username)

            // then
            assertEquals(SignUpStatus.Error.UsernameLength, formState.usernameStatus)
        }
    }

    @Test
    fun invalidUsername_containsNumberSign_returnsUsernameNonCharacterErrorStatus() {
        // given & when
        val invalidUsernames = listOf("abcd1", "abcd#", "ab1#")
        invalidUsernames.forEach { username ->
            val formState = UserForm(username = username)

            // then
            assertEquals(SignUpStatus.Error.UsernameNonCharacter, formState.usernameStatus)
        }
    }

    @Test
    fun validUsername_returnsSuccessStatus() {
        // given & when
        val formState = UserForm(username = "abcde")

        // then
        assertEquals(SignUpStatus.Success, formState.usernameStatus)
    }

    @Test
    fun emptyEmail_returnsEmptyStatus() {
        // given & when
        val formState = UserForm(email = "")

        // then
        assertEquals(SignUpStatus.Empty, formState.emailStatus)
    }

    @Test
    fun invalidEmail_inappropriateForm_returnsEmailFormatErrorStatus() {
        // given & when
        val invalidEmails = listOf("kmkim", "kmkim@", "kmkim@kr", "kmkim@kr.")
        invalidEmails.forEach { username ->
            val formState = UserForm(email = username)

            // then
            assertEquals(SignUpStatus.Error.EmailFormat, formState.emailStatus)
        }
    }

    @Test
    fun validEmail_returnsSuccessStatus() {
        // given & when
        val formState = UserForm(email = "kmkim@gmail.com")

        // then
        assertEquals(SignUpStatus.Success, formState.emailStatus)
    }

    @Test
    fun emptyPassword_returnsEmptyStatus() {
        // given & when
        val formState = UserForm(password = "")

        // then
        assertEquals(SignUpStatus.Empty, formState.passwordStatus)
    }

    @Test
    fun invalidPassword_invalidLength_returnsPasswordLengthErrorStatus() {
        // given & when
        val invalidPasswords = listOf("1234567", "12345678901234567")

        invalidPasswords.forEach { password ->
            val formState = UserForm(password = password)

            // then
            assertEquals(SignUpStatus.Error.PasswordLength, formState.passwordStatus)
        }
    }

    @Test
    fun invalidPassword_containsNoAlphabetNumber_returnsPasswordFormatErrorStatus() {
        // given & when
        val invalidPasswords = listOf("12345678", "abcdefgh", "!@#!@#!@")
        invalidPasswords.forEach { password ->
            val formState = UserForm(password = password)

            // then
            assertEquals(SignUpStatus.Error.PasswordFormat, formState.passwordStatus)
        }
    }

    @Test
    fun validPassword_returnsSuccessStatus() {
        // given & when
        val formState = UserForm(password = "abcd1234")

        // then
        assertEquals(SignUpStatus.Success, formState.passwordStatus)
    }

    @Test
    fun emptyPasswordConfirmation_returnsEmptyStatus() {
        // given & when
        val formState = UserForm(passwordConfirmation = "")

        // then
        assertEquals(SignUpStatus.Empty, formState.passwordConfirmationStatus)
    }

    @Test
    fun passwordConfirmation_notEqualPassword_returnsPasswordConfirmationErrorStatus() {
        // given & when
        val formState = UserForm(password = "abcd1234", passwordConfirmation = "abcd1235")

        // then
        assertEquals(SignUpStatus.Error.PasswordConfirmation, formState.passwordConfirmationStatus)
    }

    @Test
    fun validPasswordConfirmation_returnsSuccessStatus() {
        // given & when
        val formState = UserForm(password = "abcd1234", passwordConfirmation = "abcd1234")

        // then
        assertEquals(SignUpStatus.Success, formState.passwordConfirmationStatus)
    }

    @Test
    fun formValid_allValid_returnsTrue() {
        // given & when
        val formState =
            UserForm(
                username = "abcde",
                email = "kmkim@pengcook.com",
                password = "abcd1234",
                passwordConfirmation = "abcd1234",
            )

        val result = formState.formValid

        // then
        assertTrue(result)
    }

    @Test
    fun formValid_notAllValid_returnsFalse() {
        // given & when
        val formState =
            UserForm(
                username = "abcde",
                email = "kmkim@pengcook.com",
                password = "abcd1234",
                passwordConfirmation = "abcd1235",
            )

        val result = formState.formValid

        // then
        assertFalse(result)
    }

    @Test
    fun hasError_usernameError_returnsTrue() {
        // given & when
        val formState = UserForm(username = "a")
        val result = formState.hasError(UserForm.FormField.USERNAME)

        // then
        assertTrue(result)
    }

    @Test
    fun hasError_emailError_returnsTrue() {
        // given & when
        val formState = UserForm(email = "kmkim@pengcook")
        val result = formState.hasError(UserForm.FormField.EMAIL)

        // then
        assertTrue(result)
    }

    @Test
    fun hasError_passwordError_returnsTrue() {
        // given & when
        val formState = UserForm(password = "abcdefgh")
        val result = formState.hasError(UserForm.FormField.PASSWORD)

        // then
        assertTrue(result)
    }

    @Test
    fun hasError_passwordConfirmationError_returnsTrue() {
        // given & when
        val formState = UserForm(password = "abc12345", passwordConfirmation = "abc12346")
        val result = formState.hasError(UserForm.FormField.PASSWORD_CONFIRMATION)

        // then
        assertTrue(result)
    }

    @Test
    fun hasError_noError_returnsFalse() {
        // given & when
        val formState = UserForm(
            username = "abcde",
            email = "kmkim@pengcook.com",
            password = "abcd1234",
            passwordConfirmation = "abcd1234"
        )
        val result = formState.hasError(UserForm.FormField.USERNAME)

        // then
        assertFalse(result)
    }

    @Test
    fun errorMessageResourceOf_invalidUsernameLength_returnsUsernameLengthErrorMessage() {
        // given & when
        val formState = UserForm(username = "a")
        val result = formState.errorMessageResourceOf(UserForm.FormField.USERNAME)

        // then
        assertEquals(R.string.error_username_length, result)
    }

    @Test
    fun errorMessageResourceOf_invalidUsernameNonCharacter_returnsUsernameNonCharacterErrorMessage() {
        // given & when
        val formState = UserForm(username = "abcd#")
        val result = formState.errorMessageResourceOf(UserForm.FormField.USERNAME)

        // then
        assertEquals(R.string.error_username_non_character, result)
    }

    @Test
    fun errorMessageResourceOf_invalidEmailFormat_returnsEmailFormatErrorMessage() {
        // given & when
        val formState = UserForm(email = "kmkim@pengcook")
        val result = formState.errorMessageResourceOf(UserForm.FormField.EMAIL)

        // then
        assertEquals(R.string.error_email_format, result)
    }

    @Test
    fun errorMessageResourceOf_invalidPasswordLength_returnsPasswordLengthErrorMessage() {
        // given & when
        val formState = UserForm(password = "kmk4567")
        val result = formState.errorMessageResourceOf(UserForm.FormField.PASSWORD)

        // then
        assertEquals(R.string.error_password_length, result)
    }

    @Test
    fun errorMessageResourceOf_invalidPasswordFormat_returnsPasswordFormatErrorMessage() {
        // given & when
        val formState = UserForm(password = "abcdefgh")
        val result = formState.errorMessageResourceOf(UserForm.FormField.PASSWORD)

        // then
        assertEquals(R.string.error_password_format, result)
    }

    @Test
    fun errorMessageResourceOf_invalidPasswordConfirmation_returnsPasswordConfirmationErrorMessage() {
        // given & when
        val formState = UserForm(password = "abc12345", passwordConfirmation = "abc12346")
        val result = formState.errorMessageResourceOf(UserForm.FormField.PASSWORD_CONFIRMATION)

        // then
        assertEquals(R.string.error_password_confirmation, result)
    }
}
