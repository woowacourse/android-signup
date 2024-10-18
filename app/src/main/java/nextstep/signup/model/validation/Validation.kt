package nextstep.signup.model.validation

interface Validation {
    fun validate(text: String): Boolean
    fun errorMessage(text: String): String
}
