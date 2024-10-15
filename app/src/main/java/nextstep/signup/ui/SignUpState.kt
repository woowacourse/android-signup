package nextstep.signup.ui

import nextstep.signup.model.Email
import nextstep.signup.model.Password
import nextstep.signup.model.UserName

data class SignUpState(
    val username: UserName = UserName(),
    val email: Email = Email(),
    val password: Password = Password(),
    val passwordConfirm: Password = Password(),
) {
    val enabled: Boolean
        get() =
            username.value.isNotBlank() &&
                email.value.isNotBlank() &&
                password.value.isNotBlank() &&
                passwordConfirm.value.isNotBlank() &&
                !username.validate().isError &&
                !email.validate().isError &&
                !password.validate().isError &&
                !passwordConfirm.validateConfirmation(password).isError
}
