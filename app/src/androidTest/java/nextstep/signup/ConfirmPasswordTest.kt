package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.junit4.createComposeRule
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
    private val confirmPassword = mutableStateOf("")

    @Before
    fun setup() {
        composeTestRule.setContent {
            SignUpTextFieldComponent(
                signUpModel = ConfirmPassword(password = password, text = confirmPassword.value),
                onTextChange = { confirmPassword.value = it },
                labelText = stringResource(R.string.password_confirm_label),
                isPassword = true
            )
        }
    }

    @Test
    fun 확인비밀번호가_빈_값일_때_Blank_상태를_반환한다() {
        confirmPassword.value = ""
        composeTestRule
            .onNodeWithText(stringResource(R.string.password_confirm_label))
            .assertExists()
    }

    @Test
    fun 확인비밀번호가_원래비밀번호와_다를_때_Confirm_에러를_반환한다() {
        confirmPassword.value = "wrongPassword"
        composeTestRule
            .onNodeWithText(stringResource(R.string.password_confirm_label))
            .assertExists()
    }

    @Test
    fun 확인비밀번호가_유효할_때_유효_상태인_Valid를_반환한다() {
        confirmPassword.value = "password"
        composeTestRule
            .onNodeWithText(stringResource(R.string.password_confirm_label))
            .assertExists()
    }
}

