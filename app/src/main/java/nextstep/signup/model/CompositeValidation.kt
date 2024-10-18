package nextstep.signup.model

class CompositeValidation(
    private vararg val validations: Validation
) : Validation {
    override fun validate(text: String): Boolean =
        validations.all { it.validate(text) }

    override fun errorMessage(text: String): String =
        filterUnpassedValidations(text).joinToString(separator = "\n") { it.errorMessage(text) }

    private fun filterUnpassedValidations(text: String): List<Validation> =
        validations.filter { !it.validate(text) }
}
