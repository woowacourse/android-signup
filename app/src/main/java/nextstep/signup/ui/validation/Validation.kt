package nextstep.signup.ui.validation

interface Validation {
    fun validate(text: String): ValidationResult
}
