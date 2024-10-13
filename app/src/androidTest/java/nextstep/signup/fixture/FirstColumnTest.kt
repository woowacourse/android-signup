package nextstep.signup.fixture

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FirstColumnTest(text: String) {
    Column(
        modifier = Modifier.testTag("이름")
    ) {
        Text(text = text, color = Color.Gray)
        Text(text = "킴포즈", color = Color.Cyan)
        Text(text = "끔포즈", color = Color.Yellow)
    }
}

@Preview
@Composable
fun FirstColumnTestPreview() {
    FirstColumnTest("첫 번째")
}