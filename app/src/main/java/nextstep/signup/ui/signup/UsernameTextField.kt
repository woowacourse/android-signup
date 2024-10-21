package nextstep.signup.ui.signup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.R
import nextstep.signup.model.validation.CompositeValidation
import nextstep.signup.model.validation.LengthValidation
import nextstep.signup.model.validation.RegexValidation
import nextstep.signup.model.validation.Validation

@Composable
fun UsernameTextField(
    username: MutableState<String>,
    validation: Validation,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit = {},
) {
    SignUpTextField(
        modifier = modifier,
        label = stringResource(R.string.username),
        text = username,
        onValueChange = onValueChange,
        isError = !validation.validate(username.value),
        errorMessage = validation.errorMessage(username.value)
    )
}
@Preview(showBackground = true)
@Composable
fun UsernameTextFieldPreview() {
    val lengthValidation = LengthValidation(2..5, stringResource(R.string.username_length_error))
    val characterValidation = RegexValidation("[a-zA-Z가-힣]+".toRegex(), stringResource(R.string.username_character_error))
    val userNameValidation = CompositeValidation(lengthValidation, characterValidation)
    UsernameTextField(
        username = remember { mutableStateOf("") },
        validation = userNameValidation,
        )
}
