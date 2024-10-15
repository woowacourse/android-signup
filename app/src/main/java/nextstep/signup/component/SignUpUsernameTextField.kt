package nextstep.signup.component

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import nextstep.signup.R

@Composable
internal fun SignUpUsernameTextField(
    modifier: Modifier = Modifier,
    username: String,
    onUsernameChange: (String) -> Unit,
) {
    TextField(
        modifier = modifier,
        value = username,
        onValueChange = { onUsernameChange(it) },
        label = { Text(stringResource(R.string.input_hint_username)) },
        supportingText = { },
    )
}
