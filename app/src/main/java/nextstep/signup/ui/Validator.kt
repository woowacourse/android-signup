package nextstep.signup.ui

object Validator {
    private const val USERNAME_REGEX = "^[a-zA-Z가-힣]+$"
    private const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
    private const val PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,16}$"

    fun getUserNameError(userName: String, lengthError: String, formatError: String): String {
        return when {
            userName.length !in 2..5 -> lengthError
            !userName.matches(Regex(USERNAME_REGEX)) -> formatError
            else -> ""
        }
    }

    fun getEmailError(email: String, formatError: String): String {
        return if (!email.matches(Regex(EMAIL_REGEX))) {
            formatError
        } else {
            ""
        }
    }

    fun getPasswordError(password: String, lengthError: String, formatError: String): String {
        return when {
            password.length !in 8..16 -> lengthError
            !password.matches(Regex(PASSWORD_REGEX)) -> formatError
            else -> ""
        }
    }
}
