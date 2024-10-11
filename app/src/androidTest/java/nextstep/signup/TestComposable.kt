package nextstep.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun TextComposable() {
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
fun ColumnComposable() {
    Column(
        modifier = Modifier.testTag("이름"),
    ) {
        Text(text = "깜포즈", color = Color.Blue)
        Text(text = "킴포즈", color = Color.Cyan)
        Text(text = "끔포즈", color = Color.Yellow)
    }
}

@Composable
fun ButtonComposable() {
    val enabled = remember { mutableStateOf(true) }
    Button(
        onClick = {
            enabled.value = false
        },
        enabled = enabled.value,
        modifier = Modifier.testTag("버튼"),
    ) {
        Text("클릭해주세요")
    }
}
