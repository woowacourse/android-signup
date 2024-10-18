package nextstep.signup

import nextstep.signup.InputValidationResult.Empty
import nextstep.signup.InputValidationResult.LengthError
import nextstep.signup.InputValidationResult.Valid
import nextstep.signup.InputValidationResult.WrongFormat

data class UsernameState(
    val username: String = ""
) {
    fun validate(): InputValidationResult {
        if (username.isEmpty()) {
            return Empty
        }

        if (username.length !in USERNAME_MINIMUM_LENGTH..USERNAME_MAXIMUM_LENGTH) {
            return LengthError
        }

        if (username.matches(Regex(USERNAME_REGEX)).not()) {
            return WrongFormat
        }

        return Valid
    }

    companion object {
        private const val USERNAME_REGEX = "^[a-zA-Z가-힣]+$"
        private const val USERNAME_MINIMUM_LENGTH = 2
        private const val USERNAME_MAXIMUM_LENGTH = 10
    }
}
