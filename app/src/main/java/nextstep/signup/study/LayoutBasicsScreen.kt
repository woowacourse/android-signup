package nextstep.signup.study

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun HelloCompose(text: String) {
    Text(
        // 바꿔 보세요!
        text = text,
        color = Color.Blue,
        style = TextStyle(
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif
        )
    )
}

@Composable
fun KimposeKKmPose(
    text0: String,
    text1: String,
    text2: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        // 바꿔 보세요!
        Text(text = text0, color = Color.Red)
        Text(text = text1, color = Color.Cyan)
        Text(text = text2, color = Color.Yellow)
    }
}

@Composable
fun MyButton(modifier: Modifier = Modifier) {
    val enabled = remember { mutableStateOf(true) }
    Button(
        onClick = {
            enabled.value = !enabled.value
        },
        enabled = enabled.value,
        modifier = modifier
    ) {
        Text(text = "클릭해주세요")
    }
}

@Preview
@Composable
private fun HelloComposePreview() {
    HelloCompose("안녕 난 컴포즈야~")
}

@Preview
@Composable
private fun KimposeKKmPosePreview() {
    KimposeKKmPose("깜포즈", "킴포즈", "끔포즈")
}

@Preview()
@Composable
private fun MyButtonPreview() {
    MyButton()
}
