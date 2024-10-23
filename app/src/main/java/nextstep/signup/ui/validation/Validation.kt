package nextstep.signup.ui.validation

interface Validation {
    fun validate(text: String): Boolean
    fun errorMessage(text: String): String
}
