package nextstep.signup

import androidx.compose.runtime.mutableStateOf
import nextstep.signup.ui.model.SignUpState
import nextstep.signup.ui.model.Username
import org.junit.Test

class UsernameTest {

    private val username = mutableStateOf("")

    @Test
    fun 사용자_이름이_빈_값이면_Blank_상태를_반환한다() {
        username.value = ""
        val result = Username(username.value).validState()
        assert(result is SignUpState.Blank)
    }

    @Test
    fun 사용자_이름이_2자_미만이면_UserNameLength_에러를_반환한다() {
        username.value = "김"
        val result = Username(username.value).validState()
        assert(result is SignUpState.InValid.UserNameLength)
    }

    @Test
    fun 사용자_이름이_5자_초과이면_UserNameLength_에러를_반환한다() {
        username.value = "김누누입니다"
        val result = Username(username.value).validState()
        assert(result is SignUpState.InValid.UserNameLength)
    }

    @Test
    fun 사용자_이름이_유효할_경우_유효_상태인_Valid를_반환한다() {
        username.value = "김누누임"
        val result = Username(username.value).validState()
        assert(result is SignUpState.Valid)
    }
}
