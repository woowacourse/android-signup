package nextstep.signup.ui.auth.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
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
    private val userNameValidateResult: UserNameValidateResult get() = UserName.validate(userName)
    private val emailValidateResult: EmailValidateResult get() = Email.validate(email)
    private val passwordValidateResult: PasswordValidateResult get() = Password.validate(password)
    private val passwordConfirmValidateResult: PasswordConfirmValidateResult
        get() = PasswordConfirm.validate(
            password,
            passwordConfirm
        )

    val enableSignUp: Boolean
        get() =
            userNameValidateResult.isValid &&
                emailValidateResult.isValid &&
                passwordValidateResult.isValid &&
                passwordConfirmValidateResult.isValid

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
