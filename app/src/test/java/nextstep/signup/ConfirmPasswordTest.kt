package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import nextstep.signup.ui.model.ConfirmPassword
import nextstep.signup.ui.model.Password
import nextstep.signup.ui.model.SignUpState
import org.junit.Test

class ConfirmPasswordTest {

    private val password = Password(text = "password")
    private val confirmPassword = mutableStateOf("")

    @Test
    fun 확인비밀번호가_빈_값이면_Blank_상태를_반환한다() {
        confirmPassword.value = ""
        val result = ConfirmPassword(password, confirmPassword.value).isValidState()
        assert(result is SignUpState.Blank)
    }

    @Test
    fun 확인비밀번호가_원래비밀번호와_다르면_Confirm_에러를_반환한다() {
        confirmPassword.value = "wrongPassword"
        val result = ConfirmPassword(password, confirmPassword.value).isValidState()
        assert(result is SignUpState.InValid.Confirm)
    }

    @Test
    fun 확인비밀번호가_유효할_경우_유효_상태인_Valid를_반환한다() {
        confirmPassword.value = "password"
        val result = ConfirmPassword(password, confirmPassword.value).isValidState()
        assert(result is SignUpState.Valid)
    }
}
