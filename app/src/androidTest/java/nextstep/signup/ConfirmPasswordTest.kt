package nextstep.signup

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.ui.component.SignUpTextFieldComponent
import nextstep.signup.ui.model.ConfirmPassword
import nextstep.signup.ui.model.Password
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ConfirmPasswordTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val password = Password(text = "password")
    private var confirmPassword by mutableStateOf(ConfirmPassword(password))
    private var errorConfirmPassword = ""

    @Before
    fun setup() {
        composeTestRule.setContent {
            errorConfirmPassword = stringResource(R.string.error_confirm)

            SignUpTextFieldComponent(
                signUpModel = ConfirmPassword(password = password, text = confirmPassword.text),
                onTextChange = { confirmPassword = ConfirmPassword(password = password, text = it) },
                labelText = stringResource(R.string.password_confirm_label),
                isPassword = true
            )
        }
    }

    @Test
    fun 확인비밀번호가_빈_값일_때_Blank_메시지를_표시한다() {
        confirmPassword = ConfirmPassword(password = password)
        composeTestRule
            .onAllNodesWithText("")
    }

    @Test
    fun 확인비밀번호가_원래비밀번호와_다를_때_Confirm_에러_메시지를_표시한다() {
        confirmPassword = ConfirmPassword(password = password, "wrongPassword")
        composeTestRule
            .onNodeWithText(errorConfirmPassword)
            .assertExists()
    }

    @Test
    fun 확인비밀번호가_유효할_때_유효_상태인_메시지를_표시한다() {
        confirmPassword = ConfirmPassword(password = password, "password")
        composeTestRule
            .onNodeWithText(errorConfirmPassword)
            .assertDoesNotExist()
    }
}
