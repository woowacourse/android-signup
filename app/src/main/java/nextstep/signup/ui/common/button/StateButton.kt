package nextstep.signup.ui.common.button

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.ui.theme.SignUpTheme
import nextstep.signup.ui.theme.Typography

@Composable
fun StateButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier,
        enabled = enabled,
        onClick = { onClick() },
    ) {
        Text(
            text = text,
            style = Typography.bodyMedium,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    SignUpTheme {
        StateButton(text = "dlrjqhkfk~") {}
    }
}
