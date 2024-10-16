package nextstep.signup.fixtures

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import nextstep.signup.ui.model.ValidationResult

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
