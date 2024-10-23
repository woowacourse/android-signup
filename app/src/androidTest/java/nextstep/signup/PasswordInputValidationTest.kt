package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.domain.Password
import nextstep.signup.domain.PasswordConfirm
import nextstep.signup.ui.common.textfield.InputType
import nextstep.signup.ui.common.textfield.SingleLineTextInput
import nextstep.signup.ui.signup.SignUpValidator.getValidationMessage
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PasswordInputValidationTest {
    @get:Rule
    val composeTestRule = createComposeRule()
    private val password = mutableStateOf(Password(""))
    private val passwordConfirm = mutableStateOf(PasswordConfirm())

    @Before
    fun setup() {
        composeTestRule.setContent {
            SingleLineTextInput(
                label = "비밀번호 테스트",
                value = password.value.value,
                onValueChange = { password.value = Password(it) },
                inputType = InputType.Password,
                supportingText = password.value.getValidationMessage(),
            )

            SingleLineTextInput(
                label = "비밀번호 확인 테스트",
                value = passwordConfirm.value.value,
                onValueChange = { passwordConfirm.value = PasswordConfirm(it) },
                inputType = InputType.Password,
                supportingText =
                    passwordConfirm.value.getValidationMessage(
                        password.value.value,
                    ),
            )
        }
    }

    @Test
    fun `비밀번호는_8에서_16자여야_한다`() {
        // when
        password.value = Password("abcd1234")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_LENGTH_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun `비밀번호가_8에서_16자가_아니면_에러메시지가_노출된다`() {
        // when
        password.value = Password("abcd12")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_LENGTH_ERROR)
            .assertExists()
    }

    @Test
    fun `비밀번호에_영문과_숫자가_포함되어야_한다`() {
        // when
        password.value = Password("abcd1234xyz")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_FORMAT_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun `비밀번호에_영문과_숫자가_함께_포함되지_않으면_에러메시지가_노출된다`() {
        // when
        password.value = Password("abcdefgh")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_FORMAT_ERROR)
            .assertExists()
    }

    @Test
    fun `비밀번호_확인_시_비밀번호가_일치해야_한다`() {
        // when
        password.value = Password("abcd1234")
        passwordConfirm.value = PasswordConfirm("abcd1234")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_CONFIRM_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun `비밀번호가_일치하지_않으면_에러메시지가_노출된다`() {
        // when
        password.value = Password("abcd5678")
        passwordConfirm.value = PasswordConfirm("abcd1234")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_CONFIRM_ERROR)
            .assertExists()
    }

    companion object {
        private const val PASSWORD_LENGTH_ERROR = "비밀번호는 8~16자여야 합니다."
        private const val PASSWORD_FORMAT_ERROR = "비밀번호는 영문과 숫자를 포함해야 합니다."
        private const val PASSWORD_CONFIRM_ERROR = "비밀번호가 일치하지 않습니다."
    }
}
