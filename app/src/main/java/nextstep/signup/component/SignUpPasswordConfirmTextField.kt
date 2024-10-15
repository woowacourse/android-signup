package nextstep.signup.component

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import nextstep.signup.R

@Composable
internal fun SignUpPasswordConfirmTextField(
    modifier: Modifier = Modifier,
    passwordConfirm: String,
) {

    TextField(
        modifier = modifier,
        value = passwordConfirm,
        onValueChange = { },
        label = { Text(stringResource(R.string.input_hint_password_confirm)) },
        supportingText = { },
        visualTransformation = PasswordVisualTransformation(),
    )
}
