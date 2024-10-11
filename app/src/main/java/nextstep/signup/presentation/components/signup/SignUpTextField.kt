package nextstep.signup.presentation.components.signup

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.VisualTransformation
import nextstep.signup.ui.theme.BlueGrey20
import nextstep.signup.ui.theme.PurpleGrey40

@Composable
fun SignUpTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        visualTransformation = visualTransformation,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = BlueGrey20,
            unfocusedContainerColor = BlueGrey20,
            errorContainerColor = Color.Red,
            disabledContainerColor = PurpleGrey40
        ),
        modifier =
        Modifier
            .fillMaxWidth()
    )
}
