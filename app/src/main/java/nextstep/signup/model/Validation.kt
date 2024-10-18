package nextstep.signup.model

interface Validation {
    fun validate(text: String): Boolean
    fun errorMessage(text: String): String
}
