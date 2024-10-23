package nextstep.signup.ui.validation

class EqualValidation(
    private val src: String,
    private val errorMessage: String,
): Validation {
    override fun validate(text: String): Boolean = text == src

    override fun errorMessage(text: String): String = errorMessage
}
