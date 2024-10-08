package nextstep.signup.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SubjectComponent(
    subject: String,
    emoji: String? = null,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 34.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(
            text = subject,
            fontSize = 26.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
        )
        if (emoji != null) {
            Text(
                text = emoji,
                fontSize = 26.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Preview(
    backgroundColor = 0xFFFFFFFF,
    showBackground = true
)
@Composable
fun PreviewSubjectComponent() {
    SubjectComponent(
        subject = "Welcome to Compose",
        emoji = "🚀",
    )
}
