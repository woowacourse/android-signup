package nextstep.signup.study

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun HelloCompose(text: String, modifier: Modifier = Modifier) {
    Text(
        // 바꿔 보세요!
        text = "안녕 난 컴포즈야~",
        color = Color.Blue,
        style = TextStyle(
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif
        ),
    )
}

@Preview
@Composable
private fun HelloComposePreview() {
    HelloCompose("안녕 난 컴포즈야~")
}