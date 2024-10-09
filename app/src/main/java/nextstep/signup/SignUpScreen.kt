package nextstep.signup

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun SignUpHeader(modifier: Modifier = Modifier) {
    Text(
        text = "Welcome to Compose 🚀",
        style = TextStyle(
            fontSize =26.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif

        )
    )
}

@Preview
@Composable
private fun SignUpHeaderPreview() {
    SignUpHeader()
}
