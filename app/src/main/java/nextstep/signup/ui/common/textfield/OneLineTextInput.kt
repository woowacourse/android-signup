package nextstep.signup.ui.common.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import nextstep.signup.ui.theme.FocusedColor

@Composable
fun OneLineTextInput(
    label: String,
    inputType: InputType,
) {
    var value by rememberSaveable { mutableStateOf("") }
    TextField(
        modifier = Modifier
            .fillMaxWidth(),
        value = value,
        onValueChange = { value = it },
        label = {
            LabelText(label = label)
        },
        singleLine = true,
        visualTransformation = inputType.visualTransformation,
        keyboardOptions = inputType.keyboardOptions,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = FocusedColor,
            focusedLabelColor = FocusedColor,
        ),
        textStyle = TextStyle(
            fontSize = 16.sp,
        )
    )
}

@Composable
fun LabelText(label: String) {
    Text(
        text = label,
        fontSize = 12.sp,
    )
}
