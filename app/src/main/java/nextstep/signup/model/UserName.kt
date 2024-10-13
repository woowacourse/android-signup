package nextstep.signup.model

import nextstep.signup.R

@JvmInline
value class UserName(
    val value: String = "",
) {
    fun validate(): InputValidation {
        if (value.isBlank()) return InputValidation(isError = false)
        if (!value.matches(Regex(USERNAME_REGEX))) {
            return InputValidation(
                stringRes = R.string.error_username_invalid_characters,
                isError = true,
            )
        }
        if (value.length !in 2..5) {
            return InputValidation(stringRes = R.string.error_username_length, isError = true)
        }
        return InputValidation(isError = false)
    }

    companion object {
        const val USERNAME_REGEX = "^[a-zA-Z가-힣]+$"
    }
}
