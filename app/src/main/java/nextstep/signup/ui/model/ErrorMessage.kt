package nextstep.signup.ui.model

import nextstep.signup.domain.Error

data class ErrorMessage(val error: Error) {
    val message = when (error) {
        Error.NO_ERROR -> ""
        Error.INVALID_USERNAME_LENGTH -> "이름은 2자 이상 5자 이하이여야 합니다."
        Error.INVALID_USERNAME_TYPE -> "이름에는 숫자나 기호가 포함될 수 없습니다."
        Error.INVALID_EMAIL -> "이메일 형식이 올바르지 않습니다."
        Error.INVALID_PASSWORD_LENGTH -> "비밀번호는 8자 이상 16자 이하이어야 합니다."
        Error.INVALID_PASSWORD_TYPE -> "비밀번호는 영문과 숫자를 포함해야 합니다."
        Error.INVALID_CONFIRM_PASSWORD -> "비밀번호가 일치하지 않습니다."
    }
}
