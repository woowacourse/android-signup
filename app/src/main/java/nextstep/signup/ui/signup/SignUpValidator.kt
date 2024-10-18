package nextstep.signup.ui.signup

import nextstep.signup.domain.Email
import nextstep.signup.domain.Password
import nextstep.signup.domain.Username

object SignUpValidator {
    fun Username.validateUsername(): String {
        return if (value.isEmpty()) {
            ""
        } else if (isValidFormat.not()) {
            "이름에는 숫자나 기호가 포함될 수 없습니다."
        } else if (isValidLength.not()) {
            "이름은 2~5자여야 합니다."
        } else {
            ""
        }
    }

    fun Email.validateEmail(): String {
        return if (value.isEmpty()) {
            ""
        } else if (isValidFormat.not()) {
            "이메일 형식이 올바르지 않습니다."
        } else {
            ""
        }
    }

    fun Password.validatePassword(): String {
        return if (value.isEmpty()) {
            ""
        } else if (isValidFormat.not()) {
            "비밀번호는 영문과 숫자를 포함해야 합니다."
        } else if (isValidLength.not()) {
            "비밀번호는 8~16자여야 합니다."
        } else {
            ""
        }
    }

    fun String.validatePasswordConfirm(password: String): String {
        return if (isEmpty()) {
            ""
        } else if (this != password) {
            "비밀번호가 일치하지 않습니다."
        } else {
            ""
        }
    }
}
