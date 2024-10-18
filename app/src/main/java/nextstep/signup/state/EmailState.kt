package nextstep.signup.state

import nextstep.signup.state.InputValidationResult.Empty
import nextstep.signup.state.InputValidationResult.Valid
import nextstep.signup.state.InputValidationResult.WrongFormat

data class EmailState(
    val email: String = ""
) {
    fun validate(): InputValidationResult {
        if (email.isEmpty()) {
            return Empty
        }

        if (email.matches(Regex(EMAIL_REGEX)).not()) {
            return WrongFormat
        }

        return Valid
    }

    companion object {
        private const val EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
    }
}
