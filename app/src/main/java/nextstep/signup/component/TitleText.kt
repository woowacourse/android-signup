package nextstep.signup.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun TitleText(
    modifier: Modifier = Modifier,
    title: String,
    fontSize: Int = 26,
    color: Color = Color.Black
) {
    Text(
        modifier = modifier.fillMaxWidth(),
        text = title,
        fontSize = fontSize.sp,
        color = color,
        fontWeight = FontWeight.W700,
        textAlign = TextAlign.Center
    )
}

@Composable()
@Preview
private fun TitleTextPreview() {
    TitleText(title = "Title")
}
