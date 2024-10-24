package nextstep.signup.model.validation

class EqualValidation(
    private val src: String,
) : Validation {
    override fun validate(text: String): ValidationResult =
        if (text == src) ValidationResult.Success else ValidationResult.EqualError
}
