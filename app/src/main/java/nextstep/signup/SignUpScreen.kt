package nextstep.signup

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SignUpHeader(modifier: Modifier = Modifier) {
    Text(
        text = "Welcome to Compose 🚀",
        style = TextStyle(
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif

        )
    )
}

@Composable
fun SignUpTextField(modifier: Modifier = Modifier, labelText: String = "Enter Text") {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        maxLines = 1,
        label = { Text(text = labelText) },
        modifier = modifier,
    )
}

@Composable
fun SignUpButton(modifier: Modifier = Modifier) {
    val enabled = remember { mutableStateOf(true) }
    Button(
        onClick = {
            enabled.value = !enabled.value
        },
        enabled = enabled.value,
        modifier = modifier.then(Modifier.fillMaxWidth())
    ) {
        Text(
            text = "Sign Up",
            fontSize = 14.sp,
        )
    }
}

@Preview
@Composable
private fun SignUpHeaderPreview() {
    SignUpHeader()
}

@Preview
@Composable
private fun SignUpTextFieldPreview() {
    SignUpTextField()
}

@Preview
@Composable
private fun SignUpButtonPreview() {
    SignUpButton()
}