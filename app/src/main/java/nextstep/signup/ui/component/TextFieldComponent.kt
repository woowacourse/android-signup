package nextstep.signup.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.R
import nextstep.signup.ui.theme.Blue50

@Composable
fun TextFieldComponent(
    modifier: Modifier = Modifier,
    newValue: String,
    onValueChange: (String) -> Unit,
    @StringRes label: Int,
    keyboardType: KeyboardType = KeyboardType.Text,
) {
    TextField(
        value = newValue,
        onValueChange = { onValueChange(newValue) },
        modifier = modifier.fillMaxWidth(),
        label = { Text(text = stringResource(id = label)) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
        colors = TextFieldDefaults.colors(focusedIndicatorColor = Blue50),
    )
}

@Preview(showBackground = true)
@Composable
private fun TextFieldPreview() {
    TextFieldComponent(
        newValue = "",
        onValueChange = {},
        label = R.string.main_user_name,
    )
}
