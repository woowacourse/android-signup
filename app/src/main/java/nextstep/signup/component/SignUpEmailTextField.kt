package nextstep.signup.component

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import nextstep.signup.R

@Composable
internal fun SignUpEmailTextField(
    modifier: Modifier = Modifier,
    email: String
) {
    TextField(
        modifier = modifier,
        value = email,
        onValueChange = { },
        label = { Text(stringResource(R.string.input_hint_email)) },
        supportingText = { },
    )
}
