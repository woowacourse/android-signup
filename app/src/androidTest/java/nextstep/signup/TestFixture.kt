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
import androidx.compose.ui.unit.sp

object TestFixture {
    const val BACKGROUND_PREVIEW_COLOR = 0xFFFFFFFF
    const val TEST_TEXT = "안녕 난 컴포즈야~"
    const val TEST_TAG = "tag"
    const val TEST_BUTTON_TAG = "buttonTag"
    private const val BUTTON_MESSAGE = "클릭해주세요"

    @Composable
    fun MakeTestText(text: String) {
        TextComponent(
            text = text,
            color = Color.Blue
        )
    }

    @Composable
    fun MakeTestButton(
        enabled: Boolean,
        onChangeEnabled: () -> Unit
    ) {
        ButtonComponent(
            enabled = enabled,
            onChangeEnabled = onChangeEnabled
        )
    }

    @Composable
    fun MakeColumnText() {
        Column(
            modifier = Modifier.testTag(TEST_TAG)
        ) {
            TextComponent(text = TEST_TEXT, color = Color.Cyan)
            TextComponent(text = TEST_TEXT, color = Color.Yellow)
        }
    }

    @Composable
    fun TextComponent(
        text: String,
        color: Color
    ) {
        Text(
            text = text,
            color = color,
            style = TextStyle(
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif
            )
        )
    }

    @Composable
    fun ButtonComponent(
        enabled: Boolean,
        onChangeEnabled: () -> Unit,
        buttonTag: String = TEST_BUTTON_TAG,
        buttonText: String = BUTTON_MESSAGE
    ) {
        Button(
            onClick = {
                onChangeEnabled()
            },
            enabled = enabled,
            modifier = Modifier.testTag(buttonTag)
        ) {
            Text(text = buttonText)
        }
    }
}
