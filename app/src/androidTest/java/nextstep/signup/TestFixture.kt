package nextstep.signup

import nextstep.signup.domain.Email
import nextstep.signup.domain.Password
import nextstep.signup.domain.PasswordConfirm
import nextstep.signup.domain.Username

val invalidLengthUsername = Username("u")
val invalidFormatUsername = Username("user!")
val invalidFormatEmail = Email("in valid @ema&il.woowa!han")
val invalidLengthPassword = Password("pass12")
val invalidFormatPassword = Password("password")
val mismatchPasswordConfirm = PasswordConfirm("different1234")

val validUsername = Username("user")
val validEmail = Email("valid@email.com")
val validPassword = Password("password123")
val validPasswordConfirm = PasswordConfirm("password123")
