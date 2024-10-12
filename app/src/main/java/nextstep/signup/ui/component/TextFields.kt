package nextstep.signup.ui.component

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import nextstep.signup.ui.theme.BlueGrey20

@Composable
fun InputText(
    @StringRes stringRes: Int,
    keyBoardType: KeyboardType = KeyboardType.Text,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    val title = stringResource(stringRes)
    var contents: String by remember { mutableStateOf("") }
    TextField(
        contents,
        label = { Text(text = title) },
        onValueChange = { contents = it },
        keyboardOptions = KeyboardOptions(keyboardType = keyBoardType),
        visualTransformation = visualTransformation,
        colors =
            TextFieldDefaults.colors(
                unfocusedContainerColor = BlueGrey20,
                focusedContainerColor = BlueGrey20,
            ),
    )
    Spacer(Modifier.height(36.dp))
}
