package nextstep.signup.ui

import nextstep.signup.model.InputValidation

data class InputFieldConfig(
    val value: String,
    val onValueChange: (String) -> Unit,
    val model: InputValidation,
    val label: String
)
