package nextstep.signup.fixtures.ui.main

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.R
import nextstep.signup.ui.component.SignUpField
import nextstep.signup.ui.model.Password
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PasswordInputValidationTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val password = mutableStateOf(Password())

    @Before
    fun setup() {
        composeTestRule.setContent {
            SignUpField(
                labelId = R.string.signup_password_label,
                value = password.value.value,
                onValueChange = { password.value = password.value.copy(value = it) },
                signUpResult = password.value.validation,
            )
        }
    }

    @Test
    fun `비밀번호는_8에서_16자여야_한다`() {
        // when
        password.value = Password(value = "abcdefg123")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_LENGTH_WARNING_MESSAGE)
            .assertDoesNotExist()
    }

    @Test
    fun `비밀번호가_8자_미만일_경우_에러메시지가_노출된다`() {
        // when
        password.value = Password(value = "abc4567")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_LENGTH_WARNING_MESSAGE)
            .assertExists()
    }

    @Test
    fun `비밀번호가_16자를_넘을_경우_에러메시지가_노출된다`() {
        // when
        password.value = Password(value = "abcdefghijklmn123")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_LENGTH_WARNING_MESSAGE)
            .assertExists()
    }

    @Test
    fun `비밀번호는_영문과_숫자를_포함해야_한다`() {
        // when
        password.value = Password(value = "abcdefg123")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_LENGTH_WARNING_MESSAGE)
            .assertDoesNotExist()
    }

    @Test
    fun `비밀번호가_숫자를_포함하지_않으면_에러메시지가_노출된다`() {
        // when
        password.value = Password(value = "abcdefghi")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_COMPOSITION_WARNING_MESSAGE)
            .assertExists()
    }

    @Test
    fun `비밀번호가_영문을_포함하지_않으면_에러메시지가_노출된다`() {
        // when
        password.value = Password(value = "123456789")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_COMPOSITION_WARNING_MESSAGE)
            .assertExists()
    }

    companion object {
        private const val PASSWORD_COMPOSITION_WARNING_MESSAGE = "비밀번호는 영문과 숫자를 포함해야 합니다."
        private const val PASSWORD_LENGTH_WARNING_MESSAGE = "비밀번호는 8~16자여야 합니다."
    }
}
