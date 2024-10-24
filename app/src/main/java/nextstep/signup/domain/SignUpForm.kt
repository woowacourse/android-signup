package nextstep.signup.domain

import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import kotlinx.parcelize.Parcelize
import nextstep.signup.R

@Parcelize
data class SignUpForm(
    val userName: String,
    val email: String,
    val password: String,
    val passwordConfirm: String,
) : Parcelable {
    val isValidForm: Boolean
        get() {
            return (validateUserName() == ValidationState.VALID) &&
                (validateEmail() == ValidationState.VALID) &&
                (validatePassword() == ValidationState.VALID) &&
                (validatePasswordConfirm() == ValidationState.VALID)
        }

    fun validateUserName(): ValidationState {
        return if (!userName.matches(Regex(USER_NAME_FORMAT_REGEX))) {
            ValidationState.FORMAT_ERROR
        } else if (!userName.matches(Regex(USER_NAME_LENGTH_REGEX))) {
            ValidationState.LENGTH_ERROR
        } else {
            ValidationState.VALID
        }
    }

    fun validateEmail(): ValidationState {
        return if (email.matches(Regex(EMAIL_FORMAT_REGEX))) {
            ValidationState.VALID
        } else {
            ValidationState.FORMAT_ERROR
        }
    }

    fun validatePassword(): ValidationState {
        return if (!password.matches(Regex(PASSWORD_FORMAT_REGEX))) {
            ValidationState.FORMAT_ERROR
        } else if (!password.matches(Regex(PASSWORD_LENGTH_REGEX))) {
            ValidationState.LENGTH_ERROR
        } else {
            ValidationState.VALID
        }
    }

    fun validatePasswordConfirm(): ValidationState {
        return if (passwordConfirm != password) {
            ValidationState.FORMAT_ERROR
        } else {
            ValidationState.VALID
        }
    }

    @Composable
    fun getUserNameErrorMessage(): String {
        return when (validateUserName()) {
            ValidationState.VALID -> stringResource(id = R.string.empty)
            ValidationState.FORMAT_ERROR -> stringResource(id = R.string.format_error_message_user_name)
            ValidationState.LENGTH_ERROR -> stringResource(id = R.string.length_error_message_user_name)
        }
    }

    @Composable
    fun getEmailErrorMessage(): String {
        return when (validateEmail()) {
            ValidationState.FORMAT_ERROR -> stringResource(id = R.string.format_error_message_email)
            else -> stringResource(id = R.string.empty)
        }
    }

    @Composable
    fun getPasswordErrorMessage(): String {
        return when (validatePassword()) {
            ValidationState.VALID -> stringResource(id = R.string.empty)
            ValidationState.FORMAT_ERROR -> stringResource(id = R.string.format_error_message_password)
            ValidationState.LENGTH_ERROR -> stringResource(id = R.string.length_error_message_password)
        }
    }

    @Composable
    fun getPasswordConfirmErrorMessage(): String {
        return when (validatePasswordConfirm()) {
            ValidationState.FORMAT_ERROR -> stringResource(id = R.string.format_error_message_password_confirm)
            else -> stringResource(id = R.string.empty)
        }
    }

    companion object {
        const val USER_NAME_LENGTH_REGEX = "^.{2,5}$"
        const val USER_NAME_FORMAT_REGEX = "^[a-zA-Z가-힣]+$"
        const val EMAIL_FORMAT_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
        const val PASSWORD_LENGTH_REGEX = "^.{8,16}$"
        const val PASSWORD_FORMAT_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).+$"

        val emptySignUpForm = SignUpForm("", "", "", "")
    }
}
