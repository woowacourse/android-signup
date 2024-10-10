package nextstep.signup

import androidx.compose.runtime.Composable
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
import nextstep.signup.ui.theme.SignupTheme
import org.junit.Rule
import org.junit.Test

class LayoutBasicsTest {
    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun text() {
        val text = "안녕 난 컴포즈야~"
        composeTestRule.setContent {
            TextComposable()
        }

        composeTestRule
            .onNodeWithText(text)
            .assertExists()
    }

    @Test
    fun column() {
        composeTestRule.setContent {
            ColumnComposable()
        }

        composeTestRule.onNodeWithTag("이름")
            .onChildren()
            .assertCountEquals(3)
            .onFirst()
            .assert(hasText("깜포즈"))
    }

    @Test
    fun button() {
        composeTestRule.setContent {
            ButtonComposable()
        }

        val button = composeTestRule
            .onNodeWithTag("버튼")
            .performClick()

        button.assertIsNotEnabled()
    }
}

@Preview(showBackground = true)
@Composable
fun TextPreview() {
   TextComposable()
}

@Preview(showBackground = true)
@Composable
fun ColumnPreview() {
    ColumnComposable()
}

@Preview(showBackground = true)
@Composable
fun ButtonPreview() {
    ButtonComposable()
}
