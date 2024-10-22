package nextstep.signup.ui.signup

import androidx.annotation.StringRes
import nextstep.signup.R
import nextstep.signup.domain.signupinfo.Email
import nextstep.signup.domain.signupinfo.Password
import nextstep.signup.domain.signupinfo.PasswordConfirm
import nextstep.signup.domain.signupinfo.SignUpInfoResult
import nextstep.signup.domain.signupinfo.UserName

@StringRes
fun SignUpInfoResult.Fail.toUiText(): Int = when (this) {
    Email.EmailFail.Regex -> R.string.sign_up_email_error
    Password.PasswordFail.Length -> R.string.sign_up_password_length_error
    Password.PasswordFail.Regex -> R.string.sign_up_password_regex_error
    PasswordConfirm.PasswordConfirmFail.Different -> R.string.sign_up_password_confirm_error
    UserName.UserNameFail.Length -> R.string.sign_up_user_name_length_error
    UserName.UserNameFail.Regex -> R.string.sign_up_user_name_regex_error
}

@StringRes
fun SignUpInfoResult.toErrorMessageOrNull(): Int? = when (this) {
    SignUpInfoResult.Empty -> null
    is SignUpInfoResult.Success -> null
    is SignUpInfoResult.Fail -> this.toUiText()
}