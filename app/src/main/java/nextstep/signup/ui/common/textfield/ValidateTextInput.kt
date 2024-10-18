package nextstep.signup.ui.common.textfield

import android.provider.ContactsContract.CommonDataKinds.Email

const val USERNAME_REGAX = "^[a-zA-Z가-힣]+$"
const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"

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
