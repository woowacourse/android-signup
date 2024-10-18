package nextstep.signup.ui.signup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import nextstep.signup.R
import nextstep.signup.model.CompositeValidation
import nextstep.signup.model.LengthValidation
import nextstep.signup.model.RegexValidation

@Composable
fun UsernameTextField(
    username: MutableState<String>,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit = {},
) {
    val lengthValidation = LengthValidation(2..5, stringResource(R.string.username_length_error))
    val characterValidation = RegexValidation("[a-zA-Z가-힣]+".toRegex(), stringResource(R.string.username_character_error))
    val userNameValidation = CompositeValidation(lengthValidation, characterValidation)
    SignUpTextField(
        modifier = modifier,
        label = stringResource(R.string.username),
        text = username,
        onValueChange = onValueChange,
        isError = !userNameValidation.validate(username.value),
        errorMessage = userNameValidation.errorMessage(username.value)
    )
}
