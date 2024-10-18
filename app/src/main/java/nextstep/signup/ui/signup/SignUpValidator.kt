package nextstep.signup.ui.signup

import nextstep.signup.domain.Email
import nextstep.signup.domain.Password
import nextstep.signup.domain.Username

object SignUpValidator {
    fun validateUsername(username: Username): String {
        return if (username.value.isEmpty()) {
            ""
        } else if (username.isValidFormat.not()) {
            "이름에는 숫자나 기호가 포함될 수 없습니다."
        } else if (username.isValidLength.not()) {
            "이름은 2~5자여야 합니다."
        } else {
            ""
        }
    }

    fun validateEmail(email: Email): String {
        return if (email.value.isEmpty()) {
            ""
        } else if (email.isValidFormat.not()) {
            "이메일 형식이 올바르지 않습니다."
        } else {
            ""
        }
    }

    fun validatePassword(password: Password): String {
        return if (password.value.isEmpty()) {
            ""
        } else if (password.isValidFormat.not()) {
            "비밀번호는 영문과 숫자를 포함해야 합니다."
        } else if (password.isValidLength.not()) {
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
