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
            Text(
                text = text,
                color = Color.Blue,
                style =
                    TextStyle(
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif,
                    ),
            )
        }

        // then
        composeTestRule
            .onNodeWithText(text)
            .assertExists()
    }

    @Test
    fun column() {
        // given
        val testTag = "이름"
        val listTitle = listOf<String>("깜포즈", "컴포즈", "끔포즈")
        composeTestRule.setContent {
            Column(
                modifier = Modifier.testTag(testTag),
            ) {
                listTitle.forEach { title ->
                    Text(text = title, color = Color.Yellow)
                }
            }
        }

        // then
        composeTestRule
            .onNodeWithTag(testTag)
            .onChildren()
            .assertCountEquals(listTitle.size)
            .onFirst()
            .assert(hasText(listTitle.first()))
    }

    @Test
    fun button() {
        // given
        val testTag = "버튼"
        composeTestRule.setContent {
            val enabled = remember { mutableStateOf(true) }
            Button(
                onClick = {
                    if (enabled.value) enabled.value = false
                },
                enabled = enabled.value,
                modifier = Modifier.testTag(testTag),
            ) {
                Text(text = "클릭해주세요")
            }
        }

        // when
        val button =
            composeTestRule
                .onNodeWithTag(testTag)
                .performClick()

        // then
        button.assertIsNotEnabled()
    }
}

@Preview
@Composable
fun TextPreview() {
    Text(
        text = "컴포즈!",
        color = Color.Blue,
        style =
            TextStyle(
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.SansSerif,
            ),
    )
}

@Preview
@Composable
fun ColumnPreview() {
    Column(
        modifier = Modifier.testTag("이름"),
    ) {
        Text(text = "깜포즈", color = Color.Black)
        Text(text = "킴포즈", color = Color.Cyan)
        Text(text = "끔포즈", color = Color.Yellow)
    }
}

@Preview
@Composable
fun ButtonPreview() {
    val enabled = remember { mutableStateOf(true) }
    Button(
        onClick = {
            enabled.value = !enabled.value
        },
        enabled = enabled.value,
        modifier = Modifier.testTag("버튼"),
    ) {
        Text(text = "클릭해주세요")
    }
}
