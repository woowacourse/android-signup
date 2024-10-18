package nextstep.signup

import nextstep.signup.InputValidationResult.Empty
import nextstep.signup.InputValidationResult.NotSame
import nextstep.signup.InputValidationResult.Valid

data class PasswordConfirmState(
    val password: String = ""
) {
    fun validate(targetPassword: String): InputValidationResult {
        if (password.isEmpty()) {
            return Empty
        }

        if (password != targetPassword) {
            return NotSame
        }

        return Valid
    }
}
