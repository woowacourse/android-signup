package nextstep.signup.model.validation

class CompositeValidation(
    private vararg val validations: Validation
) : Validation {
    override fun validate(text: String): ValidationResult {
        val unpassedResults =
            validations.map { it.validate(text) }.filter { it !is ValidationResult.Success }
        return if (unpassedResults.isEmpty()) ValidationResult.Success else ValidationResult.CompositeError(
            unpassedResults
        )
    }
}
