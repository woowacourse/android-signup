package nextstep.signup.fixture

import nextstep.signup.domain.Email
import nextstep.signup.domain.Password
import nextstep.signup.domain.SignUp
import nextstep.signup.domain.Username

val usernameFixture = Username("test")
val emailFixture = Email("test@test.com")
val passwordFixture = Password("test1324")

val signUpFixture = SignUp(
    email = emailFixture,
    username = usernameFixture,
    password = passwordFixture,
    confirmPassword = passwordFixture
)
