package nextstep.signup.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PasswordConfirm(
    override val text: String = DEFAULT_TEXT,
    val passwordText: String = DEFAULT_TEXT,
) : SignUpInformation(),
    Parcelable {
    override fun isValid(): Boolean = isPasswordMatching()

    override fun errorMessage(): String =
        when {
            !isPasswordMatching() -> PASSWORD_MISMATCH_ERROR_MESSAGE
            else -> DEFAULT_ERROR_MESSAGE
        }

    private fun isPasswordMatching(): Boolean = text == passwordText

    companion object {
        private const val DEFAULT_TEXT = ""
        private const val DEFAULT_ERROR_MESSAGE = ""
        private const val PASSWORD_MISMATCH_ERROR_MESSAGE = "비밀번호가 일치하지 않습니다."
    }
}
