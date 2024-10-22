package nextstep.signup.ui

object Validator {
    private const val USERNAME_REGEX = "^[a-zA-Z가-힣]+$"
    private const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
    private const val PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,16}$"

    const val PASSWORD_CONFIRM_ERROR = "비밀번호가 일치하지 않습니다."

    fun getUserNameError(userName: String): String {
        return when {
            userName.length !in 2..5 -> "이름은 2~5자여야 합니다."
            !userName.matches(Regex(USERNAME_REGEX)) -> "이름에는 숫자나 기호가 포함될 수 없습니다."
            else -> ""
        }
    }

    fun getEmailError(email: String): String {
        return if (!email.matches(Regex(EMAIL_REGEX))) {
            "올바른 이메일 형식이 아닙니다."
        } else {
            ""
        }
    }

    fun getPasswordError(password: String): String {
        return when {
            password.length !in 8..16 -> "비밀번호는 8~16자여야 합니다."
            !password.matches(Regex(PASSWORD_REGEX)) -> "비밀번호는 영문과 숫자를 포함해야 합니다."
            else -> ""
        }
    }
}
