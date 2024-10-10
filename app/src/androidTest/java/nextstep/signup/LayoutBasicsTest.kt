package nextstep.signup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.ui.tooling.preview.Preview
import org.junit.Rule
import org.junit.Test

class LayoutBasicsTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun textComponentTest() {
        composeTestRule.setContent {
            TestFixture.TextComponent()
        }

        // then
        composeTestRule
            .onNodeWithText(TestFixture.PREVIEW_TEXT)
            .assertExists()
    }

    @Test
    fun columnTest() {
        composeTestRule.setContent {
            TestFixture.MakeColumnText()
        }

        // then
        composeTestRule.onNodeWithTag(TestFixture.TEST_TAG)
            .onChildren()
            .assertCountEquals(2)
            .onFirst()
            .assert(hasText(TestFixture.FIRST_TEXT))
    }

    @Test
    fun buttonTest() {
        // given
        val enabled = mutableStateOf(true)
        composeTestRule.setContent {
            TestFixture.ButtonComponent(
                onClickAction = { enabled.value = false },
                enabledState = enabled
            )
        }

        // when
        composeTestRule
            .onNodeWithTag("버튼")
            .performClick()

        // then
        composeTestRule
            .onNodeWithTag("버튼")
            .assertIsNotEnabled()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewText() {
    TestFixture.TextComponent()
}

@Preview(showBackground = true)
@Composable
fun PreviewColumnText() {
    TestFixture.MakeColumnText()
}

@Preview(showBackground = true)
@Composable
fun PreviewButton() {
    val enabled = remember { mutableStateOf(true) }
    TestFixture.ButtonComponent(
        onClickAction = { enabled.value = false },
        enabledState = enabled
    )
}
