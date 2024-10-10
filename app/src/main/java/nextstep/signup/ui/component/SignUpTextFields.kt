package nextstep.signup.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import nextstep.signup.R

@Composable
fun SignUpTextFields(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        SignUpTextField(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 36.dp),
            label = stringResource(R.string.username_label),
        )
        SignUpTextField(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 36.dp),
            label = stringResource(R.string.email_label),
            keyboardType = KeyboardType.Email,
        )
        SignUpTextField(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 36.dp),
            label = stringResource(R.string.password_label),
            keyboardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation(),
        )
        SignUpTextField(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 42.dp),
            label = stringResource(R.string.password_confirm_label),
            keyboardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation(),
        )
    }
}
