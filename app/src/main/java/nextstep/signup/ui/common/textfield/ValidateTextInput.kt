package nextstep.signup.ui.common.textfield

import android.provider.ContactsContract.CommonDataKinds.Email

const val USERNAME_REGAX = "^[a-zA-Z가-힣]+$"
const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
const val PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,16}$"

fun validateUsernameInput(input: String): String {
    return if (input.isEmpty()) {
        ""
    } else if (!input.matches(Regex(USERNAME_REGAX))) {
        "이름에는 숫자나 기호가 포함될 수 없습니다."
    } else if (input.length !in 2..5) {
        "이름은 2~5자여야 합니다."
    } else {
        ""
    }
}

fun validateEmailInput(input: String): String {
    return if (input.isEmpty()) {
        ""
    } else if (!input.matches(Regex(EMAIL_REGEX))) {
        "이메일 형식이 올바르지 않습니다."
    } else {
        ""
    }
}

fun validatePasswordInput(input: String): String {
    return if (input.isEmpty()) {
        ""
    } else if (!input.matches(Regex(PASSWORD_REGEX))) {
        "비밀번호는 영문과 숫자를 포함해야 합니다."
    } else if (input.length !in 8..16) {
        "비밀번호는 8~16자여야 합니다."
    } else {
        ""
    }
}

fun validatePasswordConfirmInput(
    password: String,
    input: String,
): String {
    return if (input.isEmpty()) {
        ""
    } else if (input != password) {
        "비밀번호가 일치하지 않습니다."
    } else {
        ""
    }
}
