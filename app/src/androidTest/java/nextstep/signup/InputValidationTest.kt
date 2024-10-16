package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.component.SignUpUsernameTextField
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class InputValidationTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val username = mutableStateOf("")

    @Before
    fun setup() {
        composeTestRule.setContent {
            SignUpUsernameTextField(username = username.value) {}
        }
    }

    @Test
    fun 사용자가_이름을_입력하기_전에는_에러가_노출되지_않는다() {
        // given
        username.value = ""

        // then
        composeTestRule
            .onNodeWithText(ERROR_USERNAME_LENGTH)
            .assertDoesNotExist()

        composeTestRule
            .onNodeWithText(ERROR_USERNAME_FORMAT)
            .assertDoesNotExist()
    }

    @Test
    fun 사용자_이름의_글자_수는_2에서_5자여야_한다() {
        // given
        username.value = "꼬상"

        // then
        composeTestRule
            .onNodeWithText(ERROR_USERNAME_LENGTH)
            .assertDoesNotExist()
    }

    @Test
    fun 사용자_이름이_2에서_5자가_아니면_에러메시지가_노출된다() {
        // given
        username.value = "포켓로그헬퍼"

        // then
        composeTestRule
            .onNodeWithText(ERROR_USERNAME_LENGTH)
            .assertExists()
    }

    @Test
    fun 사용자_이름에_숫자가_포함되면_에러메시지가_노출된다() {
        // given
        username.value = "꼬상2"

        // then
        composeTestRule
            .onNodeWithText(ERROR_USERNAME_FORMAT)
            .assertExists()
    }

    @Test
    fun 사용자_이름에_기호가_포함되면_에러메시지가_노출된다() {
        // given
        username.value = "꼬상!"

        // then
        composeTestRule
            .onNodeWithText(ERROR_USERNAME_FORMAT)
            .assertExists()
    }

    companion object {
        private const val ERROR_USERNAME_LENGTH = "이름은 2~5자여야 합니다."
        private const val ERROR_USERNAME_FORMAT = "이름에는 숫자와 기호가 포함될 수 없습니다."
        private const val ERROR_EMAIL_FORMAT = "이메일 형식이 올바르지 않습니다."
        private const val ERROR_PASSWORD_LENGTH = "비밀번호는 8~16자여야 합니다."
        private const val ERROR_PASSWORD_FORMAT = "비밀번호는 영문과 숫자를 포함해야 합니다."
        private const val ERROR_PASSWORD_CONFIRM = "비밀번호가 일치하지 않습니다."
    }
}
