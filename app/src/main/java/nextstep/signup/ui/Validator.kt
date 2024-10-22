package nextstep.signup.ui


object Validator {
    private const val USERNAME_REGEX = "^[a-zA-Z가-힣]+$"
    private const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
    private const val PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,16}$"

    const val PASSWORD_CONFIRM_ERROR = "비밀번호가 일치하지 않습니다."
    private const val USER_NAME_LENGTH_ERROR = "이름은 2~5자여야 합니다."
    private const val USER_NAME_REGEX_ERROR = "이름에는 숫자나 기호가 포함될 수 없습니다."
    private const val EMAIL_REGEX_ERROR = "올바른 이메일 형식이 아닙니다."
    private const val PASSWORD_LENGTH_ERROR = "비밀번호는 8~16자여야 합니다."
    private const val PASSWORD_REGEX_ERROR = "비밀번호는 영문과 숫자를 포함해야 합니다."

    fun getUserNameError(userName: String): String {
        return when {
            userName.length !in 2..5 -> USER_NAME_LENGTH_ERROR
            !userName.matches(Regex(USERNAME_REGEX)) -> USER_NAME_REGEX_ERROR
            else -> ""
        }
    }

    fun getEmailError(email: String): String {
        return if (!email.matches(Regex(EMAIL_REGEX))) {
            EMAIL_REGEX_ERROR
        } else {
            ""
        }
    }

    fun getPasswordError(password: String): String {
        return when {
            password.length !in 8..16 -> PASSWORD_LENGTH_ERROR
            !password.matches(Regex(PASSWORD_REGEX)) -> PASSWORD_REGEX_ERROR
            else -> ""
        }
    }
}
