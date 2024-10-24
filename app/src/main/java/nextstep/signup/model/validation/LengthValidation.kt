package nextstep.signup.model.validation

class LengthValidation(
    private val range: IntRange,
) : Validation {
    override fun validate(text: String): ValidationResult =
        if (text.length in range) ValidationResult.Success else ValidationResult.LengthError
}
