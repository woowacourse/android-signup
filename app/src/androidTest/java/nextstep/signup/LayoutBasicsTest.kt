package nextstep.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.test.assertIsEnabled
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.junit.Rule
import org.junit.Test

class LayoutBasicsTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun textTest() {
        // given
        composeTestRule.setContent {
            Text(
                text = DISPLAY_TEXT,
                color = Color.Blue,
                style = TextStyle(
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif
                ),
            )
        }

        // then
        composeTestRule
            .onNodeWithText(DISPLAY_TEXT)
            .assertExists()
    }

    @Preview(showBackground = true)
    @Composable
    private fun previewText() {
        textTest()
    }


    @Test
    fun columnTest() {
        // given
        composeTestRule.setContent {
            Column(
                modifier = Modifier.testTag("이름")
            ) {
                Text(text = names[0], color = Color.Cyan)
                Text(text = names[1], color = Color.Yellow)
                Text(text = names[2], color = Color.Green)
            }
        }

        // then
        composeTestRule.onNodeWithTag("이름")
            .onChildren()
            .assertCountEquals(3)
            .onFirst()
            .assert(hasText(names[0]))
    }

    @Test
    fun buttonTest() {
        // given
        composeTestRule.setContent {
            val enabled = remember { mutableStateOf(true) }
            Button(
                onClick = {
                    enabled.value = false
                },
                enabled = enabled.value,
                modifier = Modifier
                    .testTag(BUTTON)
                    .padding(16.dp)
            ) {
                Text(text = "클릭해줘!")
            }
        }

        // when
        composeTestRule
            .onNodeWithTag(BUTTON)
            .assertIsEnabled()
            .performClick()

        // then
        composeTestRule
            .onNodeWithTag(BUTTON)
            .assertIsNotEnabled()
    }
}
