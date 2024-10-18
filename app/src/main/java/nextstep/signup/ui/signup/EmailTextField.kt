package nextstep.signup.ui.signup

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.R
import nextstep.signup.model.validation.RegexValidation
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun EmailTextField(
    modifier: Modifier = Modifier,
    label: String,
    text: MutableState<String>,
    onValueChange: (String) -> Unit = {},
){
    val emailValidation =
        RegexValidation(
            "[a-zA-Z0-9._-]+@[a-zA-Z]+\\.+[a-zA-Z]+".toRegex(),
            stringResource(id = R.string.email_form_error)
        )
    SignUpTextField(
        modifier = modifier,
        label = label,
        text = text,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email
        ),
        isError = !emailValidation.validate(text.value),
        errorMessage = emailValidation.errorMessage(text.value),
    )
}

@Preview(showBackground = true)
@Composable
fun EmailTextFieldPreview() {
    SignupTheme {
        EmailTextField(
            label = "Email",
            text = remember { mutableStateOf("") },
        )
    }
}
