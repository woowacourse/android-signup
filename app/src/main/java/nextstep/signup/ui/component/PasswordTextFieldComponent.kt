package nextstep.signup.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.signup.ui.theme.Blue50
import nextstep.signup.ui.theme.BlueGray20
import nextstep.signup.ui.theme.Gray50

@Composable
fun PasswordTextFieldComponent(
    passwordValue: String,
    onTextChange: (newText: String) -> Unit,
    labelText: String,
    visualTransformation: VisualTransformation = PasswordVisualTransformation(),
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(
        keyboardType = KeyboardType.Password
    )
) {
    Surface(
        modifier = Modifier
            .padding(vertical = 18.dp)
    ) {
        TextField(
            value = passwordValue,
            modifier = Modifier
                .background(color = BlueGray20)
                .fillMaxWidth(),
            onValueChange = onTextChange,
            label = { Text(text = labelText) },
            singleLine = true,
            colors = TextFieldDefaults.colors(
                focusedLabelColor = Blue50,
                unfocusedLabelColor = Gray50,
                unfocusedContainerColor = BlueGray20,
                focusedContainerColor = BlueGray20,
                focusedIndicatorColor = Blue50,
                unfocusedIndicatorColor = Color.Black,
            ),
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            textStyle = TextStyle(
                color = Gray50,
                fontSize = 16.sp,
            )
        )
    }
}

@Preview(
    backgroundColor = 0xFFFFFFFF,
    showBackground = true
)
@Composable
fun PreviewPasswordTextFieldComponent() {
    PasswordTextFieldComponent(
        passwordValue = "",
        onTextChange = {},
        labelText = ""
    )
}
