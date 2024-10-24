package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import nextstep.signup.ui.model.Email
import nextstep.signup.ui.model.SignUpState
import org.junit.Test

class EmailTest {

    private val email = mutableStateOf("")

    @Test
    fun 이메일이_빈_값이면_Blank_상태를_반환한다() {
        email.value = ""
        val result = Email(email.value).isValidState()
        assert(result is SignUpState.Blank)
    }

    @Test
    fun 이메일_형식이_유효하지_않으면_Email_에러를_반환한다() {
        email.value = "invalid_email"
        val result = Email(email.value).isValidState()
        assert(result is SignUpState.InValid.Email)
    }

    @Test
    fun 이메일이_유효할_경우_유효_상태인_Valid를_반환한다() {
        email.value = "test@example.com"
        val result = Email(email.value).isValidState()
        assert(result is SignUpState.Valid)
    }
}
