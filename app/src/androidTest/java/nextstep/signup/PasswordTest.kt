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
import nextstep.signup.ui.model.Password
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PasswordTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private var password by mutableStateOf(Password())

    private var errorPasswordLength = ""
    private var errorPasswordType = ""

    @Before
    fun setup() {
        composeTestRule.setContent {
            errorPasswordLength = stringResource(R.string.error_password_length)
            errorPasswordType = stringResource(R.string.error_password_type)

            SignUpTextFieldComponent(
                signUpModel = password,
                onTextChange = { password = Password(it) },
                labelText = stringResource(R.string.password_label),
                isPassword = true
            )
        }
    }

    @Test
    fun 비밀번호가_빈_값일_때_Blank_상태를_반환한다() {
        password = Password("")
        composeTestRule
            .onAllNodesWithText("")
            .assertCountEquals(2)
    }

    @Test
    fun 비밀번호가_8자_미만일_때_PasswordLength_에러를_반환한다() {
        password = Password("12345")
        composeTestRule
            .onNodeWithText(errorPasswordLength)
            .assertExists()
    }

    @Test
    fun 비밀번호가_유효하지_않을_때_PasswordType_에러를_반환한다() {
        password = Password("abcdefgh")
        composeTestRule
            .onNodeWithText(errorPasswordType)
            .assertExists()
    }
}
