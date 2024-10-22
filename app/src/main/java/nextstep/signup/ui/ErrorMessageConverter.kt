package nextstep.signup.ui

import nextstep.signup.model.ValidationState

fun ValidationState.getErrorMessage(): String? =
    when (this) {
        is ValidationState.Valid -> null
        is ValidationState.Blank -> null
        is ValidationState.Invalid.UserName.Length -> ERROR_USERNAME_LENGTH_MESSAGE
        is ValidationState.Invalid.UserName.Format -> ERROR_USERNAME_FORMAT_MESSAGE
        is ValidationState.Invalid.Password.Length -> ERROR_PASSWORD_LENGTH_MESSAGE
        is ValidationState.Invalid.Password.Format -> ERROR_PASSWORD_FORMAT_MESSAGE
        is ValidationState.Invalid.Email.InvalidFormat -> ERROR_EMAIL_MESSAGE
        is ValidationState.Invalid.ConfirmMismatch -> ERROR_PASSWORD_CONFIRM_MESSAGE
    }

const val ERROR_EMAIL_MESSAGE = "이메일 형식이 올바르지 않습니다."
const val ERROR_PASSWORD_LENGTH_MESSAGE = "비밀번호는 8~16자여야 합니다."
const val ERROR_PASSWORD_FORMAT_MESSAGE = "비밀번호는 영문과 숫자를 포함해야 합니다."
const val ERROR_USERNAME_LENGTH_MESSAGE = "이름은 2~5자여야 합니다."
const val ERROR_USERNAME_FORMAT_MESSAGE = "이름에는 숫자나 기호가 포함될 수 없습니다."
const val ERROR_PASSWORD_CONFIRM_MESSAGE = "비밀번호가 일치하지 않습니다."
