package nextstep.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun TestText() {
    Text(
        text = "안녕 난 컴포즈야~",
        color = Color.Blue,
        style =
            TextStyle(
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
            ),
    )
}

@Composable
fun TestColumn() {
    Column(
        modifier = Modifier.testTag("이름"),
    ) {
        Text(text = "깜포즈", color = Color.Cyan)
        Text(text = "킴포즈", color = Color.Cyan)
        Text(text = "끔포즈", color = Color.Yellow)
    }
}

@Composable
fun TestButton(
    enabled: Boolean,
    onClick: () -> Unit,
) {
    Button(
        onClick = { onClick() },
        enabled = enabled,
        modifier = Modifier.testTag("버튼"),
    ) {
        Text(text = "클릭해주세요")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingTestText() {
    TestText()
}

@Preview(showBackground = false)
@Composable
fun GreetingTestColumn() {
    TestColumn()
}

@Preview(showBackground = false)
@Composable
fun GreetingTestButton() {
    TestButton(false) {
    }
}
