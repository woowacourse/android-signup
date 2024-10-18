package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.ui.signup.PasswordConfirmTextField
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class PasswordConfirmValidationTest{

    @get:Rule
    val composeTestRule = createComposeRule()
    private val password = mutableStateOf("")
    private val passwordConfirm = mutableStateOf("")

    @Before
    fun setup() {
        composeTestRule.setContent {
            PasswordConfirmTextField(
                label = "PasswordConfirm",
                password = password,
                passwordConfirm = passwordConfirm,
            )
        }
    }

    @Test
    fun 비밀번호_검증_칸과_비밀번호가_일치해야_한다() {
        // when
        password.value = "a11111111"
        passwordConfirm.value = "a11111111"

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_CONFIRM_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun 비밀번호_검증_칸과_비밀번호가_일치하지_않을_경우_오류_메시지가_노출된다() {
        // when
        password.value = "a11111111"
        passwordConfirm.value = "a11111112"

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_CONFIRM_ERROR)
            .assertExists()
    }

    companion object {
        private const val PASSWORD_CONFIRM_ERROR = "비밀번호가 일치하지 않습니다."
    }
}
