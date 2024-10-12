package nextstep.signup.ui.signup

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun ConfirmButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = false,
    onClick: () -> Unit = {},
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,
    ) {
        Text(
            modifier = modifier.padding(15.dp),
            text = text,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ConfirmButtonPreview() {
    SignupTheme {
        ConfirmButton(
            text = "Preview",
            enabled = true
        )
    }
}
