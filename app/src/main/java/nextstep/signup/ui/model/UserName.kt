package nextstep.signup.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserName(
    val text: String = DEFAULT_TEXT,
) : Information,
    Parcelable {
    override fun isValid(): Boolean = validLength() && validPattern()

    override fun errorMessage(): String =
        when {
            !validLength() -> LENGTH_ERROR_MESSAGE
            !validPattern() -> INVALID_CHARACTERS_ERROR_MESSAGE
            else -> DEFAULT_ERROR_MESSAGE
        }

    private fun validLength(): Boolean = text.length in MIN_LENGTH..MAX_LENGTH

    private fun validPattern(): Boolean = text.matches(Regex(PATTERN))

    companion object {
        private const val PATTERN = "^[a-zA-Z가-힣]+$"

        private const val MIN_LENGTH = 2
        private const val MAX_LENGTH = 5
        private const val DEFAULT_TEXT = ""
        private const val DEFAULT_ERROR_MESSAGE = ""
        private const val LENGTH_ERROR_MESSAGE = "이름은 2~5자여야 합니다."
        private const val INVALID_CHARACTERS_ERROR_MESSAGE = "이름에는 숫자나 기호가 포함될 수 없습니다."
    }
}
