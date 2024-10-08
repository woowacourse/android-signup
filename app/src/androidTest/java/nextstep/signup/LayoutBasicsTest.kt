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

// 1. 모든 테스트가 성공하도록 만들어보자
// 2. 힌트를 참고하여 Preview를 노출시킨다.
// 3. Preview의 interactive 모드를 활용하여 버튼을 클릭해본다.
class LayoutBasicsTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun text() {
        // given
        val text = TestFixture.TEST_TEXT
        composeTestRule.setContent {
            TestFixture.MakeTestText()
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
            TestFixture.MakeColumnText()
        }

        // then
        composeTestRule.onNodeWithTag(TestFixture.TEST_TAG)
            .onChildren()
            .assertCountEquals(3)
            .onFirst()
            .assert(hasText(TestFixture.TEST_TEXT))
    }

    @Test
    fun button() {
        // given
        composeTestRule.setContent {
            val enabled = remember { mutableStateOf(true) }
            TestFixture.MakeTestButton(
                enabled = enabled.value,
                onChangeEnabled = {
                    enabled.value = !enabled.value
                }
            )
        }

        // when
        val button = composeTestRule
            .onNodeWithTag(TestFixture.TEST_BUTTON_TAG)
            .performClick()

        // then
        button.assertIsNotEnabled()
    }
}

@Preview(
    showBackground = true,
    backgroundColor = TestFixture.BACKGROUND_PREVIEW_COLOR
)
@Composable
fun PreviewTextTest() {
    TestFixture.MakeTestText()
}

@Preview(
    showBackground = true,
    backgroundColor = TestFixture.BACKGROUND_PREVIEW_COLOR
)
@Composable
fun PreviewColumnTextTest() {
    TestFixture.MakeColumnText()
}

@Preview(
    showBackground = true,
    backgroundColor = TestFixture.BACKGROUND_PREVIEW_COLOR
)
@Composable
fun PreviewButtonTest() {
    val enabled = remember { mutableStateOf(false) }
    TestFixture.MakeTestButton(
        enabled = enabled.value,
        onChangeEnabled = { enabled.value = !enabled.value }
    )
}
