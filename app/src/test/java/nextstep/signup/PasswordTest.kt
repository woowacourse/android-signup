package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import nextstep.signup.ui.model.Password
import nextstep.signup.ui.model.SignUpState
import org.junit.Test

class PasswordTest {

    private val password = mutableStateOf("")

    @Test
    fun 비밀번호가_빈_값이면_Blank_상태를_반환한다() {
        password.value = ""
        val result = Password(password.value).isValidState()
        assert(result is SignUpState.Blank)
    }

    @Test
    fun 비밀번호가_8자_미만이면_PasswordLength_에러를_반환한다() {
        password.value = "12345"
        val result = Password(password.value).isValidState()
        assert(result is SignUpState.InValid.PasswordLength)
    }

    @Test
    fun 비밀번호가_유효하지_않으면_PasswordType_에러를_반환한다() {
        password.value = "qwerasdfzxc"
        val result = Password(password.value).isValidState()
        assert(result is SignUpState.InValid.PasswordType)
    }

    @Test
    fun 비밀번호가_유효할_경우_유효_상태인_Valid를_반환한다() {
        password.value = "password1234"
        val result = Password(password.value).isValidState()
        assert(result is SignUpState.Valid)
    }
}
