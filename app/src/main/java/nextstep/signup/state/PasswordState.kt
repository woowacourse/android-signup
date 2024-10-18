package nextstep.signup.state

import nextstep.signup.state.InputValidationResult.Empty
import nextstep.signup.state.InputValidationResult.LengthError
import nextstep.signup.state.InputValidationResult.Valid
import nextstep.signup.state.InputValidationResult.WrongFormat

data class PasswordState(
    val password: String = ""
) {
    fun validate(): InputValidationResult {
        if (password.isEmpty()) {
            return Empty
        }

        if (password.length !in PASSWORD_MINIMUM_LENGTH..PASSWORD_MAXIMUM_LENGTH) {
            return LengthError
        }

        if (password.matches(Regex(PASSWORD_REGEX)).not()) {
            return WrongFormat
        }

        return Valid
    }

    companion object {
        private const val PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,16}$"
        private const val PASSWORD_MINIMUM_LENGTH = 8
        private const val PASSWORD_MAXIMUM_LENGTH = 16
    }
}
