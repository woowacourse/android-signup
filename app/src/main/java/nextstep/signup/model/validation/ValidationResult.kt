package nextstep.signup.model.validation

sealed class ValidationResult {
    object Success : ValidationResult()
    object LengthError : ValidationResult()
    object RegexError: ValidationResult()
    object EqualError: ValidationResult()
    class CompositeError(val errors: List<ValidationResult>): ValidationResult()
}
