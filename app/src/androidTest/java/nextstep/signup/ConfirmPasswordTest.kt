package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.junit4.createComposeRule
import nextstep.signup.ui.component.SignUpTextFieldComponent
import nextstep.signup.ui.model.ConfirmPassword
import nextstep.signup.ui.model.Password
import nextstep.signup.ui.model.SignUpState
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ConfirmPasswordTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    
    private val password = Password(text = "Password1")
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
    fun 확인비밀번호가_빈_값이면_Blank_상태를_반환한다() {
        // when
        confirmPassword.value = ""
        
        // then
        val result = ConfirmPassword(password, confirmPassword.value).validState()
        assert(result is SignUpState.Blank)
    }

    @Test
    fun 확인비밀번호가_원래비밀번호와_다르면_Confirm_에러를_반환한다() {
        // when
        confirmPassword.value = "WrongPassword"
        
        // then
        val result = ConfirmPassword(password, confirmPassword.value).validState()
        assert(result is SignUpState.InValid.Confirm)
    }

    @Test
    fun 확인비밀번호가_유효할_경우_유효_상태인_Valid를_반환한다() {
        // when
        confirmPassword.value = "Password1"
        
        // then
        val result = ConfirmPassword(password, confirmPassword.value).validState()
        assert(result is SignUpState.Valid)
    }
}
