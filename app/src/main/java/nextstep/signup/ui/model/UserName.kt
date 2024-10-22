package nextstep.signup.ui.model

import nextstep.signup.R

data class UserName(val value: String = "") {
    val validation: SignUpResult
        get() = isValidUserName()

    private fun isValidUserName(): SignUpResult {
        return when {
            value.isEmpty() -> SignUpResult.Blank(isValid = false)

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

    private fun validateUserNameLength() = value.length in USERNAME_LENGTH

    private fun validateUserNameComposition(): Boolean =
        value.matches(
            Regex(USERNAME_REGEX),
        )

    companion object {
        private const val USERNAME_REGEX = "^[a-zA-Z가-힣]+$"
        private val USERNAME_LENGTH = 2..5
    }
}
