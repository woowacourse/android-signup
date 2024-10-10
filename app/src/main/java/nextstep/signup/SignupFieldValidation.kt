package nextstep.signup

object SignupFieldValidation {
    private const val USERNAME_REGEX = "^[a-zA-Z가-힣]+$"
    private const val USERNAME_COMPOSITION_WARNING_MESSAGE = "이름에는 숫자나 기호가 포함될 수 없습니다."
    private val USERNAME_LENGTH = 2..5
    private const val USERNAME_LENGTH_WARNING_MESSAGE = "이름은 2~5자여야 합니다."

    fun isValidUserName(userName: String): ValidationResult {
        return when {
            userName.isEmpty() -> ValidationResult(isValid = true)

            !validateUserNameLength(userName) -> ValidationResult(
                isValid = false,
                warningMessage = USERNAME_LENGTH_WARNING_MESSAGE
            )

            !validateUserNameComposition(userName) -> ValidationResult(
                isValid = false,
                warningMessage = USERNAME_COMPOSITION_WARNING_MESSAGE
            )

            else -> ValidationResult(isValid = true)
        }
    }

    private fun validateUserNameLength(userName: String) =
        userName.length in USERNAME_LENGTH

    private fun validateUserNameComposition(userName: String): Boolean =
        userName.matches(Regex(USERNAME_REGEX))
}
