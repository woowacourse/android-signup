package nextstep.signup.ui.common.textfield

const val USERNAME_REGAX = "^[a-zA-Z가-힣]+$"

fun validateUsernameInput(input: String): String {
    val nameRegex = USERNAME_REGAX.toRegex()
    return if (input.isEmpty()) {
        ""
    } else if (!nameRegex.matches(input)) {
        "이름에는 숫자나 기호가 포함될 수 없습니다."
    } else if (input.length !in 2..5) {
        "이름은 2~5자여야 합니다."
    } else {
        ""
    }
}
