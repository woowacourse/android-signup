package nextstep.signup

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import org.junit.Assert.assertTrue
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

    @Test
    fun 회원가입을_완료하는_버튼이_존재한다() {
        composeTestRule.setContent {
            SignUpSubmitButton(modifier = Modifier, text = "Sign Up") {}
        }

        composeTestRule
            .onNodeWithText("Sign Up")
            .assertExists()
    }

    @Test
    fun 회원가입을_완료하는_버튼을_클릭하면_isFinish샹태가_true이다() {
        var isFinish = false
        composeTestRule.setContent {
            SignUpSubmitButton(modifier = Modifier, text = "Sign Up", onClick = { isFinish = true })
        }

        composeTestRule
            .onNodeWithText("Sign Up")
            .performClick()

        assertTrue(isFinish)
    }
}
