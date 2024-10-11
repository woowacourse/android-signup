package nextstep.signup

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
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
import org.junit.Rule
import org.junit.Test

class LayoutBasicsTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val checked: MutableState<Boolean> = mutableStateOf(false)

    @Test
    fun text() {
        // given
        val text = "안녕 난 컴포즈야~"
        composeTestRule.setContent {
            TestText()
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
            TestColumn()
        }

        // then
        composeTestRule.onNodeWithTag("이름")
            .onChildren()
            .assertCountEquals(3)
            .onFirst()
            .assert(hasText("깜포즈"))
    }

    @Test
    fun button() {
        // given
        composeTestRule.setContent {
            TestButton(enabled = checked.value) {
                checked.value = !checked.value
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
}
