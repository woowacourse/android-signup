package nextstep.signup.ui.auth.component

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SignUpFormState(
    val userName: String,
    val email: String,
    val password: String,
    val passwordConfirm: String
) : Parcelable {
    // TODO: 회원가입 버튼 활성화 조건
    val enableSignUp: Boolean = userName.isNotEmpty() &&
            email.isNotEmpty() &&
            password.isNotEmpty() &&
            passwordConfirm.isNotEmpty()

    companion object {
        fun empty() = SignUpFormState("", "", "", "")
    }
}