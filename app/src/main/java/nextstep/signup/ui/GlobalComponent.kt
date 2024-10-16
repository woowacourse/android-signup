package nextstep.signup.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import nextstep.signup.ui.theme.Blue50

@Composable
fun TextComponent(
    modifier: Modifier = Modifier,
    description: String,
) {
    Text(
        text = description,
        modifier = modifier,
        style = MaterialTheme.typography.titleLarge,
    )
}

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

@Composable
fun ButtonComponent(
    modifier: Modifier = Modifier,
    @StringRes description: Int,
) {
    Button(
        onClick = {},
        modifier = modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = Blue50),
        contentPadding = PaddingValues(vertical = 15.dp),
    ) {
        Text(text = stringResource(id = description))
    }
}
