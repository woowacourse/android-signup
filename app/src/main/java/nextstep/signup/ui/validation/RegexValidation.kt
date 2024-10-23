package nextstep.signup.ui.validation

class RegexValidation(
    private val regex: Regex,
    private val errorMessage: String,
) : Validation {
    override fun validate(text: String): Boolean =
        regex.matches(text)

    override fun errorMessage(text: String): String = errorMessage
}
