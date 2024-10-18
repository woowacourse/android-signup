package nextstep.signup

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import nextstep.signup.InputValidationResult.Empty
import nextstep.signup.InputValidationResult.LengthError
import nextstep.signup.InputValidationResult.NotSame
import nextstep.signup.InputValidationResult.Valid
import nextstep.signup.InputValidationResult.WrongFormat

@Composable
fun UsernameTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    inputValidationResult: InputValidationResult
) {
    val supportingText: String = when (inputValidationResult) {
        Empty -> stringResource(id = R.string.input_length_error)
        LengthError -> stringResource(id = R.string.username_length_error)
        WrongFormat -> stringResource(id = R.string.username_format_error)
        else -> ""
    }
    val focusedColor: Color = if (inputValidationResult == Valid) Color.Blue else Color.Red

    DefaultTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        label = label,
        supportingText = supportingText,
        focusedLabelColor = focusedColor,
        focusedIndicatorColor = focusedColor,
        cursorColor = focusedColor
    )
}

@Composable
fun EmailTextField(
    modifier: Modifier = Modifier,
    email: String,
    onValueChange: (String) -> Unit,
    label: String,
    inputValidationResult: InputValidationResult
) {
    val focusedColor = if (inputValidationResult == Valid) Color.Blue else Color.Red
    val supportingText = when (inputValidationResult) {
        Empty -> stringResource(id = R.string.input_length_error)
        LengthError -> stringResource(id = R.string.input_length_error)
        WrongFormat -> stringResource(id = R.string.email_format_error)
        else -> ""
    }

    DefaultTextField(
        modifier = modifier,
        value = email,
        onValueChange = onValueChange,
        label = label,
        supportingText = supportingText,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        focusedLabelColor = focusedColor,
        focusedIndicatorColor = focusedColor,
        cursorColor = focusedColor
    )
}

@Composable
fun PasswordTextField(
    modifier: Modifier = Modifier,
    password: String,
    onValueChange: (String) -> Unit,
    label: String,
    inputValidationResult: InputValidationResult
) {
    val focusedColor = if (inputValidationResult == Valid) Color.Blue else Color.Red
    val supportingText = when (inputValidationResult) {
        Empty -> stringResource(id = R.string.input_length_error)
        LengthError -> stringResource(id = R.string.password_length_error)
        WrongFormat -> stringResource(id = R.string.password_format_error)
        NotSame -> stringResource(id = R.string.password_mismatch_error)
        else -> ""
    }

    DefaultTextField(
        modifier = modifier,
        value = password,
        onValueChange = onValueChange,
        label = label,
        supportingText = supportingText,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation(),
        focusedLabelColor = focusedColor,
        focusedIndicatorColor = focusedColor,
        cursorColor = focusedColor
    )
}

@Composable
private fun DefaultTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    supportingText: String = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    singleLine: Boolean = true,
    focusedLabelColor: Color,
    focusedIndicatorColor: Color,
    cursorColor: Color,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        supportingText = {
            Text(
                text = supportingText,
                color = Color.Red
            )
        },
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
