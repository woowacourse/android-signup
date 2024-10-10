package nextstep.signup

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import org.junit.Rule
import org.junit.Test

class SignUpScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 타이틀을_지정할_수_있다() {
        composeTestRule.setContent {
            SignUpTitle("wellcome~!")
        }

        composeTestRule
            .onNodeWithText("wellcome~!")
            .assertExists()
    }

    @Test
    fun 텍스트_필드의_힌트를_지정하면_힌트가_보여야한다() {
        composeTestRule.setContent {
            SingUpTextField("Username")
        }

        composeTestRule
            .onNodeWithText("Username")
            .assertExists()
    }

    @Test
    fun 텍스트_필드에_입력하면_입력한_텍스트가_보여야한다() {
        composeTestRule.setContent {
            SingUpTextField("Username")
        }

        composeTestRule
            .onNodeWithText("Username")
            .performTextInput("kkosang")


        composeTestRule
            .onNodeWithText("kkosang")
            .assertExists()
    }
}
