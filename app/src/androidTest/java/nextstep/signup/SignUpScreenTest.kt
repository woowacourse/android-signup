package nextstep.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import nextstep.signup.component.SignUpPasswordTextField
import nextstep.signup.component.SignUpSubmitButton
import nextstep.signup.component.SignUpTitle
import nextstep.signup.component.SignUpUsernameTextField
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class SignUpScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun 타이틀을_지정할_수_있다() {
        composeTestRule.setContent {
            SignUpTitle(title = "wellcome~!")
        }

        composeTestRule
            .onNodeWithText("wellcome~!")
            .assertExists()
    }

    @Test
    fun username_필드가_노출된다() {
        composeTestRule.setContent {
            SignUpUsernameTextField(username = "", onUsernameChange = {})
        }

        composeTestRule
            .onNodeWithText("Username")
            .assertExists()
    }

    @Test
    fun username_필드에_텍스트를_입력하면_입력한_텍스트가_노출된다() {
        var username by mutableStateOf("")
        composeTestRule.setContent {
            SignUpUsernameTextField(username = username, onUsernameChange = { username = it })
        }

        composeTestRule
            .onNodeWithText("Username")
            .performTextInput("kkosang")

        composeTestRule
            .onNodeWithText("kkosang")
            .assertExists()
    }

    @Test
    fun password_필드에_비밀번호를_입력하면_입력된_비밀번호가_노출되지않는다() {
        composeTestRule.setContent {
            SignUpPasswordTextField(password = "3188")
        }

        composeTestRule
            .onNodeWithText("3188")
            .assertDoesNotExist()
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
