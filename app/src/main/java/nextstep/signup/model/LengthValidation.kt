package nextstep.signup.model

class LengthValidation(
    private val range: IntRange,
    private val errorMessage: String,
) : Validation {
    override fun validate(text: String): Boolean =
        text.length in range

    override fun errorMessage(text: String): String = errorMessage
}
