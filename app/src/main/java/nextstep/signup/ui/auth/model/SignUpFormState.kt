package nextstep.signup.ui.auth.model

import android.os.Parcelable
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import kotlinx.parcelize.Parcelize
import nextstep.signup.R
import nextstep.signup.domain.Email
import nextstep.signup.domain.EmailValidateResult
import nextstep.signup.domain.Password
import nextstep.signup.domain.PasswordConfirm
import nextstep.signup.domain.PasswordConfirmValidateResult
import nextstep.signup.domain.PasswordValidateResult
import nextstep.signup.domain.UserName
import nextstep.signup.domain.UserNameValidateResult

@Parcelize
data class SignUpFormState(
    val userName: String,
    val email: String,
    val password: String,
    val passwordConfirm: String
) : Parcelable {
    val userNameValidateResult: UserNameValidateResult get() = UserName.validate(userName)
    val emailValidateResult: EmailValidateResult get() = Email.validate(email)
    val passwordValidateResult: PasswordValidateResult get() = Password.validate(password)
    val passwordConfirmValidateResult: PasswordConfirmValidateResult
        get() = PasswordConfirm.validate(
            password,
            passwordConfirm
        )

    val enableSignUp: Boolean
        get() =
            userNameValidateResult.isValid && emailValidateResult.isValid && passwordValidateResult.isValid && passwordConfirmValidateResult.isValid

    companion object {
        fun empty(): SignUpFormState {
            return SignUpFormState(
                userName = "",
                email = "",
                password = "",
                passwordConfirm = ""
            )

        }
    }
}

@Composable
fun UserNameValidateResult.toErrorMessage(): String? {
    return when (this) {
        UserNameValidateResult.Success -> null
        UserNameValidateResult.InvalidBlank -> stringResource(id = R.string.user_name_error_blank)
        UserNameValidateResult.InvalidContainNumber -> stringResource(id = R.string.user_name_error_number)
        UserNameValidateResult.InvalidContainSpecialCharacter -> stringResource(id = R.string.user_name_error_special_character)
        UserNameValidateResult.InvalidOutOfLength -> stringResource(
            id = R.string.user_name_error_length,
            UserName.MIN_LENGTH,
            UserName.MAX_LENGTH
        )
    }
}

@Composable
fun EmailValidateResult.toErrorMessage(): String? {
    return when (this) {
        EmailValidateResult.Success -> null
        EmailValidateResult.InvalidBlank -> stringResource(id = R.string.email_error_blank)
        EmailValidateResult.InvalidEmailFormat -> stringResource(id = R.string.email_error_format)
    }
}

@Composable
fun PasswordValidateResult.toErrorMessage(): String? {
    return when (this) {
        PasswordValidateResult.Success -> null
        PasswordValidateResult.InValidBlank -> stringResource(id = R.string.password_error_blank)
        PasswordValidateResult.InValidNotInLength -> stringResource(
            id = R.string.password_error_length,
            Password.MIN_LENGTH,
            Password.MAX_LENGTH
        )

        PasswordValidateResult.InValidNotContainNumber -> stringResource(id = R.string.password_error_number)
        PasswordValidateResult.InValidNotContainAlpha -> stringResource(id = R.string.password_error_alpha)
    }
}

@Composable
fun PasswordConfirmValidateResult.toErrorMessage(): String? {
    return when (this) {
        PasswordConfirmValidateResult.Success -> null
        PasswordConfirmValidateResult.InValid -> stringResource(id = R.string.password_confirm_error)
    }
}
