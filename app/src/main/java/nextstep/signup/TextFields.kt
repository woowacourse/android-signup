package nextstep.signup

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun PlainTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
) {
    DefaultTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        label = label,
    )
}

@Composable
fun EmailTextField(
    modifier: Modifier = Modifier,
    email: String,
    onValueChange: (String) -> Unit,
    label: String,
) {
    DefaultTextField(
        modifier = modifier,
        value = email,
        onValueChange = onValueChange,
        label = label,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )
}

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    password: String,
    onValueChange: (String) -> Unit,
    label: String,
) {
    DefaultTextField(
        modifier = modifier,
        value = password,
        onValueChange = onValueChange,
        label = label,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation()
    )
}

@Composable
private fun DefaultTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    singleLine: Boolean = true,
    focusedLabelColor: Color = colorResource(id = R.color.blue50),
    focusedIndicatorColor: Color = colorResource(id = R.color.blue50),
    cursorColor: Color = colorResource(id = R.color.blue50),
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        singleLine = singleLine,
        keyboardOptions = keyboardOptions,
        colors = TextFieldDefaults.colors(
            focusedLabelColor = focusedLabelColor,
            focusedIndicatorColor = focusedIndicatorColor,
            cursorColor = cursorColor
        ),
        visualTransformation = visualTransformation
    )
}