package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import nextstep.signup.component.SignUpEmailTextField
import nextstep.signup.component.SignUpPasswordConfirmTextField
import nextstep.signup.component.SignUpPasswordTextField
import nextstep.signup.component.SignUpUsernameTextField
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class InputValidationTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val username = mutableStateOf("")
    private val email = mutableStateOf("")
    private val password = mutableStateOf("")
    private val passwordConfirm = mutableStateOf("")

    @Before
    fun setUp() {
        composeTestRule.setContent {
            SignUpUsernameTextField(username = username.value) {
                username.value = it
            }
            SignUpEmailTextField(email = email.value) {
                email.value = it
            }
            SignUpPasswordTextField(password = password.value) {
                password.value = it
            }
            SignUpPasswordConfirmTextField(
                password = password.value,
                passwordConfirm = passwordConfirm.value
            ) {
                passwordConfirm.value = it
            }
        }
    }

    @Test
    fun 사용자가_이름을_입력하기_전에는_에러가_노출되지_않는다() {
        // when
        composeTestRule
            .onNodeWithText("Username")
            .performTextInput("")

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
        // when
        composeTestRule
            .onNodeWithText("Username")
            .performTextInput("꼬상")

        // then
        composeTestRule
            .onNodeWithText(ERROR_USERNAME_LENGTH)
            .assertDoesNotExist()
    }

    @Test
    fun 사용자_이름이_2에서_5자가_아니면_에러메시지가_노출된다() {
        // when
        composeTestRule
            .onNodeWithText("Username")
            .performTextInput("포켓로그헬퍼")

        // then
        composeTestRule
            .onNodeWithText(ERROR_USERNAME_LENGTH)
            .assertExists()
    }

    @Test
    fun 사용자_이름에_숫자가_포함되면_에러메시지가_노출된다() {
        // when
        composeTestRule
            .onNodeWithText("Username")
            .performTextInput("꼬상2")

        // then
        composeTestRule
            .onNodeWithText(ERROR_USERNAME_FORMAT)
            .assertExists()
    }

    @Test
    fun 사용자_이름에_기호가_포함되면_에러메시지가_노출된다() {
        // when
        composeTestRule
            .onNodeWithText("Username")
            .performTextInput("꼬상!")

        // then
        composeTestRule
            .onNodeWithText(ERROR_USERNAME_FORMAT)
            .assertExists()
    }

    @Test
    fun 이메일은_이메일의_형식을_지켜야한다() {
        // when
        composeTestRule
            .onNodeWithText("Email")
            .performTextInput("kshyun0724@naver.com")

        // then
        composeTestRule
            .onNodeWithText(ERROR_EMAIL_FORMAT)
            .assertDoesNotExist()
    }

    @Test
    fun 이메일_형식이_올바르지_않으면_에러메시지가_노출된다_1() {
        // when
        composeTestRule
            .onNodeWithText("Email")
            .performTextInput("kshyun0724naver.com")

        // then
        composeTestRule
            .onNodeWithText(ERROR_EMAIL_FORMAT)
            .assertExists()
    }

    @Test
    fun 이메일_형식이_올바르지_않으면_에러메시지가_노출된다_2() {
        // when
        composeTestRule
            .onNodeWithText("Email")
            .performTextInput("kshyun0724@navercom")

        // then
        composeTestRule
            .onNodeWithText(ERROR_EMAIL_FORMAT)
            .assertExists()
    }

    @Test
    fun 비밀번호는_8에서_16자여야_한다() {
        // given
        composeTestRule
            .onNodeWithText("Password")
            .performTextInput("12345678")

        // then
        composeTestRule
            .onNodeWithText(ERROR_PASSWORD_LENGTH)
            .assertDoesNotExist()
    }

    @Test
    fun 비밀번호는_영문과_숫자를_포함해야한다() {
        // when
        composeTestRule
            .onNodeWithText("Password")
            .performTextInput("1234567a")

        // then
        composeTestRule
            .onNodeWithText(ERROR_PASSWORD_FORMAT)
            .assertDoesNotExist()
    }

    @Test
    fun 비밀번호_형식이_올바르지_않으면_에러메시지가_노출된다() {
        // when
        composeTestRule
            .onNodeWithText("Password")
            .performTextInput("12345678")

        // then
        composeTestRule
            .onNodeWithText(ERROR_PASSWORD_FORMAT)
            .assertExists()
    }

    @Test
    fun 비밀번호와_비밀번호확인은_일치해야한다() {
        // given
        password.value = "1234567a"

        // when
        composeTestRule
            .onNodeWithText("Password Confirm")
            .performTextInput("1234567a")

        // then
        composeTestRule
            .onNodeWithText(ERROR_PASSWORD_CONFIRM)
            .assertDoesNotExist()
    }

    @Test
    fun 비밀번호와_비밀번호확인이_다르면_에러메시지가_노출된다() {
        // given
        password.value = "1234567a"

        // when
        composeTestRule.onNodeWithText("Password Confirm")
            .performTextInput("1234567b")

        // then
        composeTestRule
            .onNodeWithText(ERROR_PASSWORD_CONFIRM)
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
