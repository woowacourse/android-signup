package nextstep.signup.ui

import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun SignupTitle(modifier: Modifier = Modifier) {
    Text(
        text = "Welcome to Compose \uD83D\uDE80",
        modifier = modifier.wrapContentWidth(),
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
    )
}

@Preview(showBackground = true)
@Composable
fun SignupTitlePreview() {
    SignupTheme {
        SignupTitle(
            Modifier,
        )
    }
}
