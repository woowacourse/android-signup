package nextstep.signup.ui.validation

class RegexValidation(
    private val regex: Regex,
) : Validation {
    override fun validate(text: String): ValidationResult =
        if (regex.matches(text)) ValidationResult.Success else ValidationResult.RegexError
}
