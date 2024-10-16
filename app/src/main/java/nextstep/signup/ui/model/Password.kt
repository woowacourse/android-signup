package nextstep.signup.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Password(
    override val text: String = DEFAULT_TEXT,
) : Information(text),
    Parcelable {
    override fun isValid(): Boolean = validLength() && validPattern()

    override fun errorMessage(): String =
        when {
            !validLength() -> INVALID_LENGTH_ERROR_MESSAGE
            !validPattern() -> INVALID_PATTERN_ERROR_MESSAGE
            else -> DEFAULT_ERROR_MESSAGE
        }

    private fun validLength(): Boolean = text.length in MIN_LENGTH..MAX_LENGTH

    private fun validPattern(): Boolean = text.matches(Regex(PATTERN))

    companion object {
        private const val MIN_LENGTH = 8
        private const val MAX_LENGTH = 16
        private const val PATTERN = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,16}$"
        private const val DEFAULT_TEXT = ""
        private const val DEFAULT_ERROR_MESSAGE = ""
        private const val INVALID_LENGTH_ERROR_MESSAGE = "비밀번호는 ${MIN_LENGTH}~${MAX_LENGTH}자여야 합니다."
        private const val INVALID_PATTERN_ERROR_MESSAGE = "비밀번호는 영문과 숫자를 포함해야 합니다."
    }
}
