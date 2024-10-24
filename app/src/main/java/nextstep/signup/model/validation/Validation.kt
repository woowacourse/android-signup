package nextstep.signup.model.validation

interface Validation {
    fun validate(text: String): ValidationResult
}
