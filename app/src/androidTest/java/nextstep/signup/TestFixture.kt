package nextstep.signup

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import nextstep.signup.ui.theme.Blue50

@Composable
fun FakeSignUpField(
    value: String,
    validationResult: ValidationResult,
    onValueChange: (String) -> Unit,
) {
    TextField(
        value = value,
        onValueChange = { onValueChange(it) },
        supportingText = {
            Text(
                text = validationResult.errorMessage,
            )
        },
    )
}
