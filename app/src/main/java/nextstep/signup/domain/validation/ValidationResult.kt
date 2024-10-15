package nextstep.signup.domain.validation

enum class ValidationResult {
    EMPTY,
    SUCCESS,
    INVALID_FORMAT,
    INVALID_LENGTH,
    INVALID_MATCH,
}
