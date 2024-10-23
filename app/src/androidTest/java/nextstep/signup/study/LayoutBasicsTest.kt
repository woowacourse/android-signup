package nextstep.signup.study

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertTextEquals
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

        // then
        composeTestRule
            .onNodeWithText(text)
            .assertExists()
            .assertTextEquals("안녕 난 컴포즈야~")
    }

    @Test
    fun column() {
        // given
        composeTestRule.setContent {
            Column(
                modifier = Modifier.testTag("이름"),
            ) {
                Text(text = "컴포즈", color = Color.Cyan)
                Text(text = "킴포즈", color = Color.Cyan)
                Text(text = "끔포즈", color = Color.Yellow)
            }
        }

        // then
        composeTestRule.onNodeWithTag("이름")
            .onChildren()
            .assertCountEquals(3)
            .onFirst()
            .assert(hasText("컴포즈"))
    }

    @Test
    fun button() {
        // given
        composeTestRule.setContent {
            val enabled = remember { mutableStateOf(true) }
            Button(
                onClick = {
                    enabled.value = enabled.value.not()
                },
                enabled = enabled.value,
                modifier = Modifier.testTag("버튼"),
            ) {
                Text(text = "클릭해주세요")
            }
        }

        // when
        val button =
            composeTestRule
                .onNodeWithTag("버튼")
                .performClick()

        // then
        button.assertIsNotEnabled()
    }

    @Test
    fun `버튼을_클릭하지_않으면_enabled_상태가_유지된다`() {
        // given
        composeTestRule.setContent {
            val enabled = remember { mutableStateOf(true) }
            Button(
                onClick = {
                    enabled.value = enabled.value.not()
                },
                enabled = enabled.value,
                modifier = Modifier.testTag("버튼"),
            ) {
                Text(text = "클릭하지 말아주세요")
            }
        }

        // when
        val button = composeTestRule.onNodeWithTag("버튼")

        // then
        button.assertIsEnabled()
    }
}
