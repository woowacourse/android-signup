package nextstep.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.model.UserName
import nextstep.signup.ui.component.InputText
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UserNameInputTextTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private var userName by mutableStateOf(UserName(""))

    @Before
    fun setup() {
        composeTestRule.setContent {
            InputText(
                title = R.string.sign_up_user_name_title,
                content = userName.content,
                inputValidator = userName,
            )
        }
    }

    @Test
    fun `사용자_이름이_2자에서_5자라면_에러메세지가_출력되지_않는다`() {
        // when
        userName = UserName("김컴포즈")
        composeTestRule.waitForIdle()

        // then
        composeTestRule
            .onNodeWithText(UserName.ERROR_USERNAME_LENGTH_MESSAGE)
            .assertDoesNotExist()
    }

    @Test
    fun `사용자_이름이_2에서_5자가_아니면_에러메시지가_노출된다`() {
        // when
        userName = UserName("김컴포즈입니다")
        composeTestRule.waitForIdle()

        // then
        composeTestRule
            .onNodeWithText(UserName.ERROR_USERNAME_LENGTH_MESSAGE, useUnmergedTree = true)
            .assertExists()
    }

    @Test
    fun `사용자_이름에는_숫자나_기호가_포함될_경우_에러메세지가_표시된다`() {
        // when
        userName = UserName("예니12")
        composeTestRule.waitForIdle()

        // then
        composeTestRule
            .onNodeWithText(UserName.ERROR_USERNAME_FORMAT_MESSAGE)
            .assertExists()
    }
}
