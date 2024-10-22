package nextstep.signup.presentation.ui

import nextstep.signup.domain.Email
import nextstep.signup.domain.Password
import nextstep.signup.domain.UserName

data class SignUpState(
    val username: UserName = UserName(),
    val email: Email = Email(),
    val password: Password = Password(),
    val passwordConfirm: Password = Password(),
) {
    val enabled: Boolean
        get() = isNotBlank && isValid

    private val isNotBlank: Boolean
        get() =
            listOf(
                username.value,
                email.value,
                password.value,
                passwordConfirm.value,
            ).all { it.isNotBlank() }

    private val isValid: Boolean
        get() =
            listOf(
                username.validate(),
                email.validate(),
                password.validate(),
                passwordConfirm.validateConfirmation(password),
            ).all { !it.isError }
}
