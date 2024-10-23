package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.ui.validation.CompositeValidation
import nextstep.signup.ui.validation.LengthValidation
import nextstep.signup.ui.validation.RegexValidation
import nextstep.signup.ui.signup.PasswordTextField
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class PasswordValidationTest{

    @get:Rule
    val composeTestRule = createComposeRule()
    private val password = mutableStateOf("")

    @Before
    fun setup() {

        val passwordLengthValidation =
            LengthValidation(8..16, PASSWORD_LENGTH_ERROR)
        val passwordRegex = "^(?=.*[a-zA-Z])(?=.*[0-9]).+\$".toRegex()
        val regexValidation =
            RegexValidation(passwordRegex, PASSWORD_CHARACTER_ERROR)
        val passwordValidation = CompositeValidation(passwordLengthValidation, regexValidation)
        composeTestRule.setContent {
            PasswordTextField(
                label = "password",
                text = password,
                validation = passwordValidation,
            )
        }
    }

    @Test
    fun 비밀번호가_8에서_16자_사이여야_한다() {
        // when
        password.value = "11111111"

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_LENGTH_ERROR)
            .assertDoesNotExist()
    }

    @Test
    fun 비밀번호가_8에서_16자가_아니면_에러메시지가_노출된다() {
        // when
        password.value = "1a"

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_LENGTH_ERROR)
            .assertExists()
    }

    @Test
    fun 비밀번호가_영문_숫자_조합이_아니면_에러메시지가_노출된다() {
        // when
        password.value = "$#@!$#@#$"

        // then
        composeTestRule
            .onNodeWithText(PASSWORD_CHARACTER_ERROR)
            .assertExists()
    }

    companion object {
        private const val PASSWORD_LENGTH_ERROR = "비밀번호는 8~16자여야 합니다."
        private const val PASSWORD_CHARACTER_ERROR = "비밀번호는 영문과 숫자를 포함해야 합니다."
    }
}





