package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import nextstep.signup.ui.component.SignUpTextFieldComponent
import nextstep.signup.ui.model.Password
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PasswordTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val password = mutableStateOf("")

    @Before
    fun setup() {
        composeTestRule.setContent {
            SignUpTextFieldComponent(
                signUpModel = Password(text = password.value),
                onTextChange = { password.value = it },
                labelText = stringResource(R.string.password_label),
                isPassword = true
            )
        }
    }

    @Test
    fun 비밀번호가_빈_값일_때_Blank_상태를_반환한다() {
        password.value = ""
        composeTestRule
            .onNodeWithText(stringResource(R.string.password_label))
            .assertExists()
    }

    @Test
    fun 비밀번호가_8자_미만일_때_PasswordLength_에러를_반환한다() {
        password.value = "12345"
        composeTestRule
            .onNodeWithText(stringResource(R.string.password_label))
            .assertExists()
    }

    @Test
    fun 비밀번호가_유효하지_않을_때_PasswordType_에러를_반환한다() {
        password.value = "abcdefgh"
        composeTestRule
            .onNodeWithText(stringResource(R.string.password_label))
            .assertExists()
    }

    @Test
    fun 비밀번호가_유효할_때_유효_상태인_Valid를_반환한다() {
        password.value = "Password1"
        composeTestRule
            .onNodeWithText(stringResource(R.string.password_label))
            .assertExists()
    }
}
