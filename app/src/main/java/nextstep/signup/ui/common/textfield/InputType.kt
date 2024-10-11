package nextstep.signup.ui.common.textfield

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

enum class InputType(
    val visualTransformation: VisualTransformation,
    val keyboardOptions: KeyboardOptions,
) {
    Username(VisualTransformation.None, KeyboardOptions.Default),
    Email(VisualTransformation.None, KeyboardOptions(keyboardType = KeyboardType.Email)),
    Password(PasswordVisualTransformation(), KeyboardOptions(keyboardType = KeyboardType.Password)),
}
