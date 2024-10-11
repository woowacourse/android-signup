package nextstep.signup.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import nextstep.signup.ui.theme.Blue50

@Composable
fun TextView(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleLarge,
    )
}

@Composable
fun TextFieldView(
    paddingTop: Dp = 0.dp,
    label: String,
) {
    var input by remember { mutableStateOf("") }
    Spacer(modifier = Modifier.padding(top = paddingTop))
    TextField(
        value = input,
        onValueChange = { input = it },
        modifier = Modifier.fillMaxWidth(),
        label = { Text(text = label) },
        colors = TextFieldDefaults.colors(focusedIndicatorColor = Blue50)
    )
}

@Composable
fun ButtonView(description: String, paddingTop: Dp) {
    Spacer(modifier = Modifier.padding(top = paddingTop))
    Button(
        onClick = {},
        modifier = Modifier.fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(containerColor = Blue50),
        contentPadding = PaddingValues(vertical =  15.dp)
    ) {
        Text(text = description)
    }
}