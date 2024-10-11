package nextstep.signup.presentation.signup

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.R
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun SignUpTextField(
    modifier: Modifier = Modifier,
    labelText: String = stringResource(R.string.default_text_field_label),
    visualTransformation: VisualTransformation = VisualTransformation.None,
    value: String = "",
    onValueChange: (String) -> Unit = { },
    keyboardType: KeyboardType = KeyboardType.Text
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        maxLines = 1,
        label = { Text(text = labelText) },
        modifier = modifier,
        visualTransformation = visualTransformation,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )
    )
}

@Preview
@Composable
private fun SignUpTextFieldPreview() {
    SignupTheme {
        SignUpTextField()
    }
}
