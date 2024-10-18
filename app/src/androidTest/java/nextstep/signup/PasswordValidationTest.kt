package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.isNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.components.PasswordTextField
import nextstep.signup.state.InputValidationResult
import nextstep.signup.state.PasswordState
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PasswordValidationTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private var passwordState = mutableStateOf(PasswordState())

    @Before
    fun setup() {
        composeTestRule.setContent {
            PasswordTextField(
                password = passwordState.value.password,
                onValueChange = { passwordState.value = passwordState.value.copy(password = it) },
                label = "",
                inputValidationResult = InputValidationResult.Valid
            )
        }
    }

    @Test
    fun 비밀번호가_빈값이면_에러메시지가_노출된다() {
        // when
        passwordState.value = passwordState.value.copy(password = "")

        // then
        composeTestRule
            .onNodeWithText(INPUT_LENGTH_ERROR)
            .isDisplayed()
    }

    @Test
    fun 비밀번호는_8에서_16자여야_한다() {
        // when
        passwordState.value = passwordState.value.copy(password = "12345678")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_LENGTH_ERROR)
            .isNotDisplayed()
    }

    @Test
    fun 비밀번호는_8에서_16자가_아니면_에러메시지가_노출된다() {
        // when
        passwordState.value = passwordState.value.copy("1234567")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_LENGTH_ERROR)
            .isDisplayed()
    }

    @Test
    fun 비밀번호는_영어나_숫자여야_한다() {
        // when
        passwordState.value = passwordState.value.copy(password = "a1234567")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_FORMAT_ERROR)
            .isNotDisplayed()
    }

    @Test
    fun 비밀번호에_영어나_숫자가_아니면_에러메시지가_노출된다() {
        // when
        passwordState.value = passwordState.value.copy(password = "a123456@")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_FORMAT_ERROR)
            .isDisplayed()
    }

    companion object {
        private const val INPUT_LENGTH_ERROR = "필수 입력란 입니다."
        private const val PASSWORD_LENGTH_ERROR = "비밀번호는 8~16자여야 합니다."
        private const val PASSWORD_FORMAT_ERROR = "비밀번호는 영문과 숫자를 포함해야 합니다."
    }
}
