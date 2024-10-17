package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.junit4.createComposeRule
import nextstep.signup.ui.component.SignUpTextFieldComponent
import nextstep.signup.ui.model.Password
import nextstep.signup.ui.model.SignUpState
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
    fun 비밀번호가_빈_값이면_Blank_상태를_반환한다() {
        // when
        password.value = ""
        
        // then
        val result = Password(password.value).validState()
        assert(result is SignUpState.Blank)
    }

    @Test
    fun 비밀번호가_8자_미만이면_PasswordLength_에러를_반환한다() {
        // when
        password.value = "12345"
        
        // then
        val result = Password(password.value).validState()
        assert(result is SignUpState.InValid.PasswordLength)
    }

    @Test
    fun 비밀번호가_유효하지_않으면_PasswordType_에러를_반환한다() {
        // when
        password.value = "abcdefgh"
        
        // then
        val result = Password(password.value).validState()
        assert(result is SignUpState.InValid.PasswordType)
    }

    @Test
    fun 비밀번호가_유효할_경우_유효_상태인_Valid를_반환한다() {
        // when
        password.value = "Password1"
        
        // then
        val result = Password(password.value).validState()
        assert(result is SignUpState.Valid)
    }
}
