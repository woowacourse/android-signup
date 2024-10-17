package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.test.junit4.createComposeRule
import nextstep.signup.ui.component.SignUpTextFieldComponent
import nextstep.signup.ui.model.Email
import nextstep.signup.ui.model.SignUpState
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class EmailTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    
    private val email = mutableStateOf("")

    @Before
    fun setup() {
        composeTestRule.setContent {
            SignUpTextFieldComponent(
                signUpModel = Email(text = email.value),
                onTextChange = { email.value = it },
                labelText = stringResource(R.string.email_label),
            )
        }
    }

    @Test
    fun 이메일이_빈_값이면_Blank_상태를_반환한다() {
        // when
        email.value = ""
        
        // then
        val result = Email(email.value).validState()
        assert(result is SignUpState.Blank)
    }

    @Test
    fun 이메일_형식이_유효하지_않으면_Email_에러를_반환한다() {
        // when
        email.value = "invalid_email"
        
        // then
        val result = Email(email.value).validState()
        assert(result is SignUpState.InValid.Email)
    }

    @Test
    fun 이메일이_유효할_경우_유효_상태인_Valid를_반환한다() {
        // when
        email.value = "test@example.com"
        
        // then
        val result = Email(email.value).validState()
        assert(result is SignUpState.Valid)
    }
}
