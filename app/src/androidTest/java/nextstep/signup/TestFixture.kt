package nextstep.signup

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
    private const val BUTTON_TAG = "tag"
    private const val BUTTON_MESSAGE = "클릭해주세요"

    @Composable
    fun TextComponent(
        text: String,
        color: Color,
    ) {
        Text(
            text = text,
            color = color,
            style = TextStyle(
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif
            ),
        )
    }

    @Composable
    fun ButtonComponent(
        enabled: Boolean,
        onChangeEnabled: () -> Unit,
        buttonTag: String = BUTTON_TAG,
        buttonText: String = BUTTON_MESSAGE,
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
