package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.model.Email
import nextstep.signup.model.Password
import nextstep.signup.model.PasswordConfirm
import nextstep.signup.model.UserName
import nextstep.signup.ui.component.InputText
import org.junit.Rule
import org.junit.Test

class InputTextTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun `사용자_이름은_2에서_5자여야_한다`() {
        // given
        val userName = mutableStateOf(UserName(""))
        composeTestRule.setContent {
            InputText(
                title = R.string.sign_up_user_name_title,
                content = userName.value.content,
                inputValidator = userName.value,
            )
        }

        // when
        userName.value = UserName("김컴포즈")
        composeTestRule.waitForIdle()

        // then
        composeTestRule
            .onNodeWithText(UserName.ERROR_USERNAME_LENGTH_MESSAGE)
            .assertDoesNotExist()
    }

    @Test
    fun `사용자_이름이_2에서_5자가_아니면_에러메시지가_노출된다`() {
        // given
        val userName = mutableStateOf(UserName(""))
        composeTestRule.setContent {
            InputText(
                title = R.string.sign_up_user_name_title,
                content = userName.value.content,
                inputValidator = userName.value,
            )
        }

        // when
        userName.value = UserName("김컴포즈입니다")
        composeTestRule.waitForIdle()

        // then
        composeTestRule
            .onNodeWithText(UserName.ERROR_USERNAME_LENGTH_MESSAGE, useUnmergedTree = true)
            .assertExists()
    }

    @Test
    fun `사용자_이름에는_숫자나_기호가_포함될_경우_에러메세지가_표시된다`() {
        // given
        val userName = mutableStateOf(UserName(""))
        composeTestRule.setContent {
            InputText(
                title = R.string.sign_up_user_name_title,
                content = userName.value.content,
                inputValidator = userName.value,
            )
        }

        // when
        userName.value = UserName("예니12")
        composeTestRule.waitForIdle()

        // then
        composeTestRule
            .onNodeWithText(UserName.ERROR_USERNAME_FORMAT_MESSAGE)
            .assertExists()
    }

    @Test
    fun `유효한_형식의_이메일을_입력해야_한다`() {
        // given
        val email = mutableStateOf(Email(""))
        composeTestRule.setContent {
            InputText(
                title = R.string.sign_up_user_name_title,
                content = email.value.content,
                inputValidator = email.value,
            )
        }

        // when
        email.value = Email("choco@naver.com")
        composeTestRule.waitForIdle()

        // then
        composeTestRule
            .onNodeWithText(Email.ERROR_EMAIL_MESSAGE)
            .assertDoesNotExist()
    }

    @Test
    fun `유효하지_않은_형식의_이메일을_입력할_경우_에러메세지가_표시된다`() {
        // given
        val email = mutableStateOf(Email(""))
        composeTestRule.setContent {
            InputText(
                title = R.string.sign_up_user_name_title,
                content = email.value.content,
                inputValidator = email.value,
            )
        }

        // when
        email.value = Email("choco")
        composeTestRule.waitForIdle()

        // then
        composeTestRule
            .onNodeWithText(Email.ERROR_EMAIL_MESSAGE)
            .assertExists()
    }

    @Test
    fun `비밀번호는_8에서_16글자_사이의_영문과_숫자를_포함한다`() {
        // given
        val password = mutableStateOf(Password(""))
        composeTestRule.setContent {
            InputText(
                title = R.string.sign_up_user_name_title,
                content = password.value.content,
                inputValidator = password.value,
            )
        }

        // when
        password.value = Password("password1")
        composeTestRule.waitForIdle()

        // then
        composeTestRule
            .onNodeWithText(Password.ERROR_PASSWORD_LENGTH_MESSAGE)
            .assertDoesNotExist()
    }

    @Test
    fun `비밀번호가_8에서_16글자_사이가_아니라면_에러메세지가_노출된다`() {
        // given
        val password = mutableStateOf(Password(""))
        composeTestRule.setContent {
            InputText(
                title = R.string.sign_up_user_name_title,
                content = password.value.content,
                inputValidator = password.value,
            )
        }

        // when
        password.value = Password("pw")
        composeTestRule.waitForIdle()

        // then
        composeTestRule
            .onNodeWithText(Password.ERROR_PASSWORD_LENGTH_MESSAGE)
            .assertExists()
    }

    @Test
    fun `비밀번호가_영문과_숫자를_포함하지_않는_경우_에러메세지가_노출된다`() {
        // given
        val password = mutableStateOf(Password(""))
        composeTestRule.setContent {
            InputText(
                title = R.string.sign_up_user_name_title,
                content = password.value.content,
                inputValidator = password.value,
            )
        }

        // when
        password.value = Password("password")
        composeTestRule.waitForIdle()

        // then
        composeTestRule
            .onNodeWithText(Password.ERROR_PASSWORD_FORMAT_MESSAGE)
            .assertExists()
    }

    @Test
    fun `비밀번호_확인란_값이_비밀번호와_같지않은_경우_에러메세지가_표시된다`() {
        // given
        val password = "password12"
        val passwordConfirm = mutableStateOf(PasswordConfirm(content = "", password = password))
        composeTestRule.setContent {
            InputText(
                title = R.string.sign_up_user_name_title,
                content = passwordConfirm.value.content,
                inputValidator = passwordConfirm.value,
            )
        }

        // when
        passwordConfirm.value = passwordConfirm.value.copy(content = "password34")
        composeTestRule.waitForIdle()

        // then
        composeTestRule
            .onNodeWithText(PasswordConfirm.ERROR_PASSWORD_CONFIRM_MESSAGE)
            .assertExists()
    }

    @Test
    fun `비밀번호_확인란의_값은_비밀번호와_같아야한다`() {
        // given
        val password = "password12"
        val passwordConfirm = mutableStateOf(PasswordConfirm(content = "", password = password))
        composeTestRule.setContent {
            InputText(
                title = R.string.sign_up_user_name_title,
                content = passwordConfirm.value.content,
                inputValidator = passwordConfirm.value,
            )
        }

        // when
        passwordConfirm.value = passwordConfirm.value.copy(content = "password12")
        composeTestRule.waitForIdle()

        // then
        composeTestRule
            .onNodeWithText(PasswordConfirm.ERROR_PASSWORD_CONFIRM_MESSAGE)
            .assertDoesNotExist()
    }
}
