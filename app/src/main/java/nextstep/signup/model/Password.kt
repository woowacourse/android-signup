package nextstep.signup.model

import android.util.Log

class Password(private val value: String) : InputValidation {
    private var errorMessage: String? = null

    override fun isInValid(): Boolean {
        return regexValidate() || lengthValidate()
    }

    override fun getErrorMessage() = if (isInValid()) errorMessage else null

    private fun regexValidate(): Boolean {
        if (!value.matches(PASSWORD_REGEX.toRegex())) {
            Log.d("Password", "value: $value")
            errorMessage = ERROR_USER_PASSWORD_REGEX
            return true
        }
        return false
    }

    private fun lengthValidate(): Boolean {
        if (value.length !in MIN_LENGTH..MAX_LENGTH) {
            errorMessage = ERROR_USER_PASSWORD_LENGTH
            return true
        }
        return false
    }

    companion object {
        const val MIN_LENGTH = 8
        const val MAX_LENGTH = 16
        const val PASSWORD_REGEX = "^(?=.*[!@#\$%^&*()_+=\\-{}|:<>?,.]).+$"
        const val ERROR_USER_PASSWORD_LENGTH = "비밀번호는 $MIN_LENGTH~${MAX_LENGTH}자여야 합니다."
        const val ERROR_USER_PASSWORD_REGEX = "비밀번호에는 특수문자가 포함되어야 합니다."
    }
}
