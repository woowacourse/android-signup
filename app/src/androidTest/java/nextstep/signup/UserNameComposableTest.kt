package nextstep.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.model.UserName
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UserNameComposableTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private var username by mutableStateOf(UserName(""))

    @Before
    fun setup() {
        composeTestRule.setContent {
            UserNameComposable(
                userName = username,
                onUserNameChange = { username = username.copy(userName = it) },
            )
        }
    }

    @Test
    fun `사용자_이름은_2에서_5자여야_한다`() {
        // when
        username = UserName("해나")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_LENGTH_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun `사용자_이름이_2에서_5자가_아니면_에러메시지가_노출된다`() {
        // when
        username = UserName("해나해나입니다")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_LENGTH_ERROR)
            .assertExists()
    }

    @Test
    fun `사용자_이름에는_숫자나_기호가_포함되지_않아야_한다`() {
        // when
        username = UserName("해나")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_FORM_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun `사용자_이름에_숫자나_기호가_포함되어_있다면_에러메시지가_노출된다`() {
        // when
        username = UserName("해1&")

        // then
        composeTestRule
            .onNodeWithText(USERNAME_FORM_ERROR)
            .assertExists()
    }

    companion object {
        private const val USERNAME_LENGTH_ERROR = "이름은 2~5자여야 합니다."
        private const val USERNAME_FORM_ERROR = "이름에는 숫자나 기호가 포함될 수 없습니다."
    }
}
