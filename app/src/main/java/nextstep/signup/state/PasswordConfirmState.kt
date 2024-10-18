package nextstep.signup.state

import nextstep.signup.state.InputValidationResult.Empty
import nextstep.signup.state.InputValidationResult.NotSame
import nextstep.signup.state.InputValidationResult.Valid

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