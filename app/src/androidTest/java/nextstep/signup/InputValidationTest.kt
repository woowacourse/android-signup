package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.ui.component.InputText
import nextstep.signup.ui.validateEmail
import nextstep.signup.ui.validatePassword
import nextstep.signup.ui.validatePasswordConfirm
import nextstep.signup.ui.validateUserName
import org.junit.Rule
import org.junit.Test

class InputValidationTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val inputs = mutableStateOf("")

    @Test
    fun `사용자_이름은_2에서_5자여야_한다`() {
        // given
        composeTestRule.setContent {
            InputText(
                title = R.string.sign_up_user_name_title,
                content = inputs.value,
                onContentChange = { inputs.value = it },
                validate = { it.validateUserName() },
            )
        }

        // when
        inputs.value = "김컴포즈"
        composeTestRule.waitForIdle()

        // then
        composeTestRule
            .onNodeWithText("이름은 2~5자여야 합니다.")
            .assertDoesNotExist()
    }

    @Test
    fun `사용자_이름이_2에서_5자가_아니면_에러메시지가_노출된다`() {
        // given
        composeTestRule.setContent {
            InputText(
                title = R.string.sign_up_user_name_title,
                content = inputs.value,
                onContentChange = { inputs.value = it },
                validate = { it.validateUserName() },
            )
        }

        // when
        inputs.value = "김컴포즈입니다"
        composeTestRule.waitForIdle()

        // then
        composeTestRule
            .onNodeWithText("이름은 2~5자여야 합니다.")
            .assertExists()
    }

    @Test
    fun `사용자_이름에는_숫자나_기호가_포함될_경우_에러메세지가_표시된다`() {
        // given
        composeTestRule.setContent {
            InputText(
                title = R.string.sign_up_user_name_title,
                content = inputs.value,
                onContentChange = { inputs.value = it },
                validate = { it.validateUserName() },
            )
        }

        // when
        inputs.value = "예니12"
        composeTestRule.waitForIdle()

        // then
        composeTestRule
            .onNodeWithText("이름에는 숫자나 기호가 포함될 수 없습니다.")
            .assertExists()
    }

    @Test
    fun `이메일은_유효한_형식을_가져야_한다`() {
        // given
        composeTestRule.setContent {
            InputText(
                title = R.string.sign_up_email_title,
                content = inputs.value,
                onContentChange = { inputs.value = it },
                validate = { it.validateEmail() },
            )
        }

        // when
        inputs.value = "choco@naver.com"
        composeTestRule.waitForIdle()

        // then
        composeTestRule
            .onNodeWithText("이메일 형식이 올바르지 않습니다.")
            .assertDoesNotExist()
    }

    @Test
    fun `비밀번호는_8에서_16글자_사이의_영문과_숫자를_포함한다`() {
        // given
        composeTestRule.setContent {
            InputText(
                title = R.string.sign_up_user_name_title,
                content = inputs.value,
                onContentChange = { inputs.value = it },
                validate = { it.validatePassword() },
            )
        }

        // when
        inputs.value = "password1"
        composeTestRule.waitForIdle()

        // then
        composeTestRule
            .onNodeWithText("비밀번호는 8~16자여야 합니다.")
            .assertDoesNotExist()
    }

    @Test
    fun `비밀번호가_8에서_16글자_사이가_아니라면_에러메세지가_노출된다`() {
        // given
        composeTestRule.setContent {
            InputText(
                title = R.string.sign_up_user_name_title,
                content = inputs.value,
                onContentChange = { inputs.value = it },
                validate = { it.validatePassword() },
            )
        }

        // when
        inputs.value = "pw1"
        composeTestRule.waitForIdle()

        // then
        composeTestRule
            .onNodeWithText("비밀번호는 8~16자여야 합니다.")
            .assertExists()
    }

    @Test
    fun `비밀번호가_영문과_숫자를_포함하지_않는_경우_에러메세지가_노출된다`() {
        // given
        composeTestRule.setContent {
            InputText(
                title = R.string.sign_up_user_name_title,
                content = inputs.value,
                onContentChange = { inputs.value = it },
                validate = { it.validatePassword() },
            )
        }

        // when
        inputs.value = "password"
        composeTestRule.waitForIdle()

        // then
        composeTestRule
            .onNodeWithText("비밀번호는 영문과 숫자를 포함해야 합니다.")
            .assertExists()
    }

    @Test
    fun `비밀번호_확인란_값이_비밀번호와_같지않은_경우_에러메세지가_표시된다`() {
        // given
        val passwordContent = "password12"
        composeTestRule.setContent {
            InputText(
                title = R.string.sign_up_user_name_title,
                content = passwordContent,
                onContentChange = { },
                validate = { it.validatePassword() },
            )

            InputText(
                title = R.string.sign_up_user_name_title,
                content = inputs.value,
                onContentChange = { inputs.value = it },
                validate = { it.validatePasswordConfirm(passwordContent) },
            )
        }

        // when
        inputs.value = "password12"
        composeTestRule.waitForIdle()

        // then
        composeTestRule
            .onNodeWithText("비밀번호가 일치하지 않습니다.")
            .assertDoesNotExist()
    }

    @Test
    fun `비밀번호_확인란의_값은_비밀번호와_같아야한다`() {
        // given
        val passwordContent = "password12"
        composeTestRule.setContent {
            InputText(
                title = R.string.sign_up_user_name_title,
                content = passwordContent,
                onContentChange = { },
                validate = { it.validatePassword() },
            )

            InputText(
                title = R.string.sign_up_user_name_title,
                content = inputs.value,
                onContentChange = { inputs.value = it },
                validate = { it.validatePasswordConfirm(passwordContent) },
            )
        }

        // when
        inputs.value = "password123"
        composeTestRule.waitForIdle()

        // then
        composeTestRule
            .onNodeWithText("비밀번호가 일치하지 않습니다.")
            .assertExists()
    }
}
