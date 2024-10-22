package nextstep.signup.ui

data class SignUpFormState(
    val userName: String = "",
    val email: String = "",
    val password: String = "",
    val passwordConfirm: String = "",
    val userNameError: String = "",
    val emailError: String = "",
    val passwordError: String = "",
    val passwordConfirmError: String = ""
) {
    fun updateField(fieldType: FieldType, value: String): SignUpFormState {
        return when (fieldType) {
            FieldType.USERNAME -> {
                val error = Validator.getUserNameError(value)
                copy(userName = value, userNameError = error)
            }
            FieldType.EMAIL -> {
                val error = Validator.getEmailError(value)
                copy(email = value, emailError = error)
            }
            FieldType.PASSWORD -> {
                val error = Validator.getPasswordError(value)
                val confirmError = if (passwordConfirm.isNotEmpty() && passwordConfirm != value) {
                    Validator.PASSWORD_CONFIRM_ERROR
                } else {
                    ""
                }
                copy(password = value, passwordError = error, passwordConfirmError = confirmError)
            }
            FieldType.PASSWORD_CONFIRM -> {
                val error = if (password != value) {
                    Validator.PASSWORD_CONFIRM_ERROR
                } else {
                    ""
                }
                copy(passwordConfirm = value, passwordConfirmError = error)
            }
        }
    }
}
