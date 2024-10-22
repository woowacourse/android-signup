package nextstep.signup

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.model.Email
import nextstep.signup.model.Password
import nextstep.signup.model.PasswordConfirm
import nextstep.signup.model.User
import nextstep.signup.model.UserName
import nextstep.signup.ui.component.ButtonComponent

@Composable
fun SignUpButtonComposable(user: User) {
    ButtonComponent(enabled = user.isAbleToSubmit(), description = stringResource(id = R.string.main_sign_up))
}

@Preview(showBackground = true)
@Composable
private fun SignUpButtonComposablePreview() {
    SignUpButtonComposable(
        User(
            userName = UserName("해나"),
            email = Email("hannah@naver.com"),
            password = Password("hannah0731"),
            passwordConfirm = PasswordConfirm("hannah0731"),
        ),
    )
}
