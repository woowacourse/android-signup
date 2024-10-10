package nextstep.signup.ui.signupform

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun ConfirmButton(
    text: String,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = {},
        modifier = modifier.height(50.dp),
    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun ConfirmButtonPreview() {
    SignupTheme {
        ConfirmButton("Preview")
    }
}
