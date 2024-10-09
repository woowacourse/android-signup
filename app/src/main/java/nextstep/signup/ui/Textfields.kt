package nextstep.signup.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.R

@Composable
private fun DefaultTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onValueChange: (String) -> Unit,
) {
    TextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        label = { Text(text = label) },
        maxLines = 1,
    )
}

@Composable
fun PlainTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
) {
    DefaultTextField(
        modifier = modifier,
        label = label,
        value = value,
        onValueChange = onValueChange
    )
}

@Composable
fun EmailTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
) {
    DefaultTextField(
        modifier = modifier,
        label = label,
        value = value,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        onValueChange = onValueChange
    )
}

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
) {
    DefaultTextField(
        modifier = modifier,
        label = label,
        value = value,
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        onValueChange = onValueChange
    )
}

@Preview
@Composable
private fun DefaultTextFieldPreview() {
    var value by remember { mutableStateOf("") }

    DefaultTextField(
        modifier = Modifier.fillMaxWidth(),
        label = "Username",
        value = value,
        visualTransformation = VisualTransformation.None,
        keyboardOptions = KeyboardOptions(),
        onValueChange = { changedValue -> value = changedValue }
    )
}

@Preview
@Composable
private fun PlainTextFieldPreview() {
    var value by remember { mutableStateOf("") }

    PlainTextField(
        modifier = Modifier.fillMaxWidth(),
        label = "Username",
        value = value,
        onValueChange = { changedValue -> value = changedValue }
    )
}

@Preview
@Composable
private fun EmailTextFieldPreview() {
    var email by remember { mutableStateOf("") }

    EmailTextField(
        modifier = Modifier.fillMaxWidth(),
        label = stringResource(id = R.string.signup_label_email),
        value = email,
        onValueChange = { changedValue -> email = changedValue }
    )
}

@Preview
@Composable
private fun PasswordTextFieldPreview() {
    var password by remember { mutableStateOf("") }

    PasswordTextField(
        modifier = Modifier.fillMaxWidth(),
        label = stringResource(id = R.string.signup_label_password),
        value = password,
        onValueChange = { changedValue -> password = changedValue }
    )
}

