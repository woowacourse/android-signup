package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.isNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.components.PasswordTextField
import nextstep.signup.state.PasswordConfirmState
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PasswordConfirmValidationTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private var passwordConfirmState = mutableStateOf(PasswordConfirmState())

    @Before
    fun setup() {
        composeTestRule.setContent {
            PasswordTextField(
                password = passwordConfirmState.value.password,
                onValueChange = { passwordConfirmState.value = passwordConfirmState.value.copy(password = it) },
                label = "",
                inputValidationResult = passwordConfirmState.value.validate("a1234567")
            )
        }
    }

    @Test
    fun 비밀번호_확인은_빈값이면_에러메시지가_노출된다() {
        // when
        passwordConfirmState.value = passwordConfirmState.value.copy(password = "")

        // then
        composeTestRule
            .onNodeWithText(INPUT_LENGTH_ERROR)
            .isDisplayed()
    }

    @Test
    fun 비밀번호가_확인이_같아야한다() {
        // when
        passwordConfirmState.value = passwordConfirmState.value.copy(password = "a1234567")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_MISMATCH_ERROR)
            .isNotDisplayed()
    }

    @Test
    fun 비밀번호_확인이_다르면_에러메시지가_노출된다() {
        // when
        passwordConfirmState.value = passwordConfirmState.value.copy(password = "a123456")

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_MISMATCH_ERROR)
            .isDisplayed()
    }

    companion object {
        private const val INPUT_LENGTH_ERROR = "필수 입력란 입니다."
        private const val PASSWORD_MISMATCH_ERROR = "비밀번호가 일치하지 않습니다."
    }
}
