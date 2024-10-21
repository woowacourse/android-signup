package nextstep.signup.ui.model

import nextstep.signup.R

data class SignUpInfo(
    val userName: String = "",
    val email: String = "",
    val password: String = "",
    val confirmedPassword: String = "",
) {
    val userNameValidation: SignUpResult
        get() = isValidUserName()

    val emailValidation: SignUpResult
        get() = isValidEmail()

    val passwordValidation: SignUpResult
        get() = isValidPassword()

    val confirmedPasswordValidation: SignUpResult
        get() = isValidConfirmedPassword()

    val signUpInfoValidation: Boolean
        get() = userNameValidation.isValid && emailValidation.isValid && passwordValidation.isValid && confirmedPasswordValidation.isValid

    private fun isValidUserName(): SignUpResult {
        return when {
            userName.isEmpty() -> SignUpResult.Blank(isValid = false)

            !validateUserNameLength() ->
                SignUpResult.Error(
                    isValid = false,
                    errorMessage = R.string.signup_username_length_error,
                )

            !validateUserNameComposition() ->
                SignUpResult.Error(
                    isValid = false,
                    errorMessage = R.string.signup_username_composition_error,
                )

            else -> SignUpResult.Success(isValid = true)
        }
    }

    private fun isValidEmail(): SignUpResult {
        return when {
            email.isEmpty() -> SignUpResult.Blank(isValid = false)

            !validateEmailComposition() ->
                SignUpResult.Error(
                    false,
                    R.string.signup_email_composition_error,
                )

            else -> SignUpResult.Success(isValid = true)
        }
    }

    private fun isValidPassword(): SignUpResult {
        return when {
            password.isEmpty() -> SignUpResult.Blank(isValid = false)

            !validatePasswordLength() ->
                SignUpResult.Error(
                    isValid = false,
                    errorMessage = R.string.signup_password_length_error,
                )

            !validatePasswordComposition() ->
                SignUpResult.Error(
                    isValid = false,
                    errorMessage = R.string.signup_password_composition_error,
                )

            else -> SignUpResult.Success(isValid = true)
        }
    }

    private fun isValidConfirmedPassword(): SignUpResult {
        return when {
            confirmedPassword.isEmpty() -> SignUpResult.Blank(isValid = false)

            !validateConfirmedPassword(password, confirmedPassword) ->
                SignUpResult.Error(
                    isValid = false,
                    errorMessage = R.string.signup_password_confirm_error,
                )

            else -> SignUpResult.Success(isValid = true)
        }
    }

    private fun validateUserNameLength() = userName.length in USERNAME_LENGTH

    private fun validateUserNameComposition(): Boolean =
        userName.matches(
            Regex(USERNAME_REGEX),
        )

    private fun validateEmailComposition(): Boolean =
        email.matches(
            Regex(EMAIL_REGEX),
        )

    private fun validatePasswordLength() = password.length in PASSWORD_LENGTH

    private fun validatePasswordComposition(): Boolean =
        password.matches(
            Regex(PASSWORD_REGEX),
        )

    private fun validateConfirmedPassword(
        password: String,
        confirmedPassword: String,
    ) = password == confirmedPassword

    companion object {
        private const val USERNAME_REGEX = "^[a-zA-Z가-힣]+$"
        private val USERNAME_LENGTH = 2..5

        private const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"

        private const val PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,16}$"
        private val PASSWORD_LENGTH = 8..16
    }
}
