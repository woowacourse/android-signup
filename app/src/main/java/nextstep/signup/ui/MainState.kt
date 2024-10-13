package nextstep.signup.ui

import nextstep.signup.model.Email
import nextstep.signup.model.Password
import nextstep.signup.model.UserName

data class MainState(
    val username: UserName = UserName(),
    val email: Email = Email(),
    val password: Password = Password(),
    val passwordConfirm: Password = Password(),
)
