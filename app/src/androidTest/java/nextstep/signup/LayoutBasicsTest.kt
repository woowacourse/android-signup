package nextstep.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onChildren
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import nextstep.signup.ui.theme.SignupTheme
import org.junit.Rule
import org.junit.Test

class LayoutBasicsTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun text() {
        // given
        val text = "안녕 난 컴포즈야~"
        composeTestRule.setContent {
            TextComposable(text)
        }

        // then
        composeTestRule
            .onNodeWithText(text)
            .assertExists()
    }

    @Test
    fun column() {
        // given
        composeTestRule.setContent {
            ColumnComposable()
        }

        // then
        composeTestRule
            .onNodeWithTag("이름")
            .onChildren()
            .assertCountEquals(3)
            .onFirst()
            .assert(hasText("깜포즈"))
    }

    @Test
    fun button() {
        // given
        val enabled = mutableStateOf(true)
        composeTestRule.setContent {
            ButtonComposable(enabled.value, { enabled.value = !enabled.value })
        }

        // when
        val button =
            composeTestRule
                .onNodeWithTag("버튼")
                .performClick()

        // then
        button.assertIsNotEnabled()
    }
}

@Composable
fun TextComposable(
    text: String,
    color: Color = Color.Blue,
) {
    Text(
        text = text,
        color = color,
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
        TextComposable("깜포즈", Color.Cyan)
        TextComposable("킴포즈", Color.Cyan)
        TextComposable("끔포즈", Color.Yellow)
    }
}

@Composable
fun ButtonComposable(
    enabled: Boolean,
    onClickChanged: () -> Unit,
) {
    Button(
        onClick = { onClickChanged() },
        enabled = enabled,
        modifier = Modifier.testTag("버튼"),
    ) {
        Text(text = "클릭해주세요")
    }
}

@Preview(showBackground = true)
@Composable
fun TextPreview() {
    TextComposable("테스트용")
}

@Preview(showBackground = true)
@Composable
fun ColumnPreview() {
    SignupTheme {
        ColumnComposable()
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    ButtonComposable(true, { })
}
