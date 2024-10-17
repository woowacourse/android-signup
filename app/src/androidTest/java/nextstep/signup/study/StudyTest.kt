package nextstep.signup.study

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    fun textTest() {
        // given
        val text = "안녕 난 컴포즈야~"
        composeTestRule.setContent {
            ComposeText(text = text)
        }

        // then
        composeTestRule.onNodeWithText(text).assertExists()
    }

    @Test
    fun columnTest() {
        // given
        val tag = "이름"
        val target = "깜포즈"
        composeTestRule.setContent {
            ComposeColumn(tag = tag, target = target)
        }

        // then
        composeTestRule
            .onNodeWithTag(tag)
            .onChildren()
            .assertCountEquals(3)
            .onFirst()
            .assert(hasText(target))
    }

    @Test
    fun buttonTest() {
        // given
        val tag = "버튼"
        composeTestRule.setContent {
            val enabled = remember { mutableStateOf(true) }
            ComposeButton(tag = tag, enabled = enabled)
        }

        // when
        val button = composeTestRule.onNodeWithTag(tag).performClick()

        // then
        button.assertIsNotEnabled()
    }
}

@Composable
fun ComposeText(
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
fun ComposeColumn(
    tag: String,
    target: String,
) {
    Column(
        modifier = Modifier.testTag(tag),
    ) {
        ComposeText(text = target, color = Color.Red)
        ComposeText(text = "킴포즈", color = Color.Cyan)
        ComposeText(text = "끔포즈", color = Color.Yellow)
    }
}

@Composable
fun ComposeButton(
    tag: String,
    enabled: MutableState<Boolean>,
) {
    Button(
        onClick = {
            enabled.value = !enabled.value
        },
        enabled = enabled.value,
        modifier = Modifier.testTag(tag),
    ) {
        val text = if (enabled.value) "Enabled" else "Disabled"
        ComposeText(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun TextTestPreview() {
    SignupTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
        ) {
            val text = "안녕 난 컴포즈야~"
            ComposeText(text)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ColumnTestPreview() {
    SignupTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
        ) {
            val tag = "이름"
            val target = "깜포즈"
            ComposeColumn(tag = tag, target = target)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ButtonTestPreview() {
    SignupTheme {
        Surface(
            color = MaterialTheme.colorScheme.background,
        ) {
            val tag = "버튼"
            val enabled = remember { mutableStateOf(true) }
            ComposeButton(tag = tag, enabled = enabled)
        }
    }
}
