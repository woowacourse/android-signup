package nextstep.signup.ui

data class ValidationResult(
    val isError: Boolean,
    val errorMessage: String? = null,
) {
    companion object {
        val DEFAULT_RESULT = ValidationResult(false, null)
    }
}

fun String.validateUserName(): ValidationResult =
    when {
        this.length !in 2..5 -> ValidationResult(true, "이름은 2~5자여야 합니다.")
        !this.matches(Regex(USERNAME_REGEX)) -> ValidationResult(true, "이름에는 숫자나 기호가 포함될 수 없습니다.")
        else -> ValidationResult(false)
    }

fun String.validateEmail(): ValidationResult =
    if (this.matches(Regex(EMAIL_REGEX))) {
        ValidationResult(false)
    } else {
        ValidationResult(
            true,
            "이메일 형식이 올바르지 않습니다.",
        )
    }

fun String.validatePassword(): ValidationResult =
    when {
        this.length !in 8..16 -> ValidationResult(true, "비밀번호는 8~16자여야 합니다.")
        !this.matches(Regex(PASSWORD_REGEX)) -> ValidationResult(true, "비밀번호는 영문과 숫자를 포함해야 합니다.")
        else -> ValidationResult(false)
    }

fun String.validatePasswordConfirm(password: String): ValidationResult =
    if (this == password) {
        ValidationResult(false)
    } else {
        ValidationResult(
            true,
            "비밀번호가 일치하지 않습니다.",
        )
    }

const val USERNAME_REGEX = "^[a-zA-Z가-힣]+$"
const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
const val PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,16}$"
