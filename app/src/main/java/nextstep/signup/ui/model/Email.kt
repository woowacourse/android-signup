package nextstep.signup.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Email(
    override val text: String = DEFAULT_TEXT,
) : SignUpInformation(),
    Parcelable {
    override fun isValid(): Boolean = validPattern()

    override fun errorMessage(): String =
        when {
            !validPattern() -> INVALID_PATTERN_ERROR_MESSAGE
            else -> DEFAULT_ERROR_MESSAGE
        }

    private fun validPattern(): Boolean = text.matches(Regex(PATTERN))

    companion object {
        private const val PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"
        private const val DEFAULT_TEXT = ""
        private const val DEFAULT_ERROR_MESSAGE = ""
        private const val INVALID_PATTERN_ERROR_MESSAGE = "이메일 형식이 올바르지 않습니다."
    }
}
