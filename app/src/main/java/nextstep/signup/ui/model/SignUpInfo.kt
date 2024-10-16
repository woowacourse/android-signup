package nextstep.signup.ui.model

data class SignUpInfo(
    val userName: String = "",
    val email: String = "",
    val password: String = "",
    val confirmedPassword: String = "",
) {
    val userNameValidation: ValidationResult
        get() = isValidUserName()

    val emailValidation: ValidationResult
        get() = isValidEmail()

    val passwordValidation: ValidationResult
        get() = isValidPassword()

    val confirmedPasswordValidation: ValidationResult
        get() = isValidConfirmedPassword()

    val signUpInfoValidation: Boolean
        get() = userNameValidation.isValid && emailValidation.isValid && passwordValidation.isValid && confirmedPasswordValidation.isValid

    private fun isValidUserName(): ValidationResult {
        return when {
            userName.isEmpty() -> ValidationResult(isValid = false)

            !validateUserNameLength() ->
                ValidationResult(
                    isValid = false,
                    errorMessage = USERNAME_LENGTH_ERROR_MESSAGE,
                )

            !validateUserNameComposition() ->
                ValidationResult(
                    isValid = false,
                    errorMessage = USERNAME_COMPOSITION_ERROR_MESSAGE,
                )

            else -> ValidationResult(isValid = true)
        }
    }

    private fun isValidEmail(): ValidationResult {
        return when {
            email.isEmpty() -> ValidationResult(isValid = false)

            !validateEmailComposition() ->
                ValidationResult(
                    false,
                    EMAIL_COMPOSITION_ERROR_MESSAGE,
                )

            else -> ValidationResult(isValid = true)
        }
    }

    private fun isValidPassword(): ValidationResult {
        return when {
            password.isEmpty() -> ValidationResult(isValid = false)

            !validatePasswordLength() ->
                ValidationResult(
                    isValid = false,
                    errorMessage = PASSWORD_LENGTH_ERROR_MESSAGE,
                )

            !validatePasswordComposition() ->
                ValidationResult(
                    isValid = false,
                    errorMessage = PASSWORD_COMPOSITION_ERROR_MESSAGE,
                )

            else -> ValidationResult(isValid = true)
        }
    }

    private fun isValidConfirmedPassword(): ValidationResult {
        return when {
            confirmedPassword.isEmpty() -> ValidationResult(isValid = false)

            !validateConfirmedPassword(password, confirmedPassword) ->
                ValidationResult(
                    isValid = false,
                    errorMessage = PASSWORD_CONFIRM_ERROR_MESSAGE,
                )

            else -> ValidationResult(isValid = true)
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
        private const val USERNAME_COMPOSITION_ERROR_MESSAGE = "이름에는 숫자나 기호가 포함될 수 없습니다."

        private val USERNAME_LENGTH = 2..5
        private const val USERNAME_LENGTH_ERROR_MESSAGE = "이름은 2~5자여야 합니다."

        private const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
        private const val EMAIL_COMPOSITION_ERROR_MESSAGE = "이메일 형식이 올바르지 않습니다."

        private const val PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,16}$"
        private const val PASSWORD_COMPOSITION_ERROR_MESSAGE = "비밀번호는 영문과 숫자를 포함해야 합니다."

        private val PASSWORD_LENGTH = 8..16
        private const val PASSWORD_LENGTH_ERROR_MESSAGE = "비밀번호는 8~16자여야 합니다."

        private const val PASSWORD_CONFIRM_ERROR_MESSAGE = "비밀번호가 일치하지 않습니다."
    }
}
