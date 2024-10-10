package nextstep.signup.ui.common.textfield

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

enum class InputType(
    val visualTransformation: VisualTransformation,
    val keyboardOptions: KeyboardOptions,
) {
    USERNAME(VisualTransformation.None, KeyboardOptions.Default),
    EMAIL(VisualTransformation.None, KeyboardOptions(keyboardType = KeyboardType.Email)),
    PASSWORD(PasswordVisualTransformation(), KeyboardOptions(keyboardType = KeyboardType.Password)),
}
