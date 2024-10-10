package nextstep.signup.presentation.signup

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.ui.theme.SignupTheme
import nextstep.signup.ui.theme.Typography

@Composable
fun SignUpHeader(
    modifier: Modifier = Modifier,
    text: String = "Welcome to Compose 🚀",
) {
    Text(
        text = text,
        style = Typography.headlineLarge,
        modifier = modifier,
    )
}

@Preview
@Composable
private fun SignUpHeaderPreview() {
    SignupTheme {
        SignUpHeader()
    }
}
