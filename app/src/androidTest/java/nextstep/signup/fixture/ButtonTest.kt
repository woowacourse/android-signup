package nextstep.signup.fixture

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ButtonTest(
    enabled: Boolean,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = Modifier.testTag("버튼")
    ) {
        Text(text = "클릭해주세요")
    }
}

@Preview
@Composable
fun ButtonTestPreview() {
    var isBtnEnable by remember { mutableStateOf(true) }

    ButtonTest(
        enabled = isBtnEnable,
        onClick = {
            isBtnEnable = false
        }
    )

}