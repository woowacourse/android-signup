package nextstep.signup.ui.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.R
import nextstep.signup.domain.SignUpForm
import nextstep.signup.domain.signupinfo.Email
import nextstep.signup.domain.signupinfo.Password
import nextstep.signup.domain.signupinfo.PasswordConfirm
import nextstep.signup.domain.signupinfo.SignUpInfoResult
import nextstep.signup.domain.signupinfo.UserName
import nextstep.signup.ui.component.SingleLineTextField
import nextstep.signup.ui.theme.SignupTheme
import nextstep.signup.ui.theme.Typography

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    val (signUp, onValueChange) = remember {
                        mutableStateOf(
                            SignUpUiModel()
                        )
                    }
                    SignUpScreen(signUp, onValueChange)
                }
            }
        }
    }
}

@Composable
fun SignUpScreen(
    uiModel: SignUpUiModel,
    onValueChange: (SignUpUiModel) -> Unit
) {

    val userNameResult = UserName.from(uiModel.userName, Regex("^[a-zA-Z가-힣]+$"))
    val emailResult = Email.from(uiModel.email)
    val passwordResult = Password.from(uiModel.password)
    val passwordConfirmResult = PasswordConfirm.from(uiModel.passwordConfirm, uiModel.password)

    Column(
        modifier = Modifier.padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(60.dp))

        Text(
            text = stringResource(R.string.sign_up_title),
            style = Typography.titleLarge
        )
        Spacer(Modifier.height(42.dp))

        SingleLineTextField(
            text = uiModel.userName,
            onTextChange = {
                onValueChange(uiModel.copy(userName = it))
            },
            isError = userNameResult is SignUpInfoResult.Fail,
            errorMessage = userNameResult.toErrorMessageOrNull(),
            label = R.string.sign_up_input_user_name
        )

        Spacer(Modifier.height(42.dp))

        SingleLineTextField(
            text = uiModel.email,
            onTextChange = {
                onValueChange(uiModel.copy(email = it))
            },
            isError = emailResult is SignUpInfoResult.Fail,
            errorMessage = emailResult.toErrorMessageOrNull(),
            label = R.string.sign_up_input_user_email,
            keyBoardType = KeyboardType.Email,
        )

        Spacer(Modifier.height(42.dp))

        SingleLineTextField(
            text = uiModel.password,
            onTextChange = {
                onValueChange(uiModel.copy(password = it))
            },
            modifier = Modifier.fillMaxWidth(),
            isError = passwordResult is SignUpInfoResult.Fail,
            errorMessage = passwordResult.toErrorMessageOrNull(),
            label = R.string.sign_up_input_user_password,
            keyBoardType = KeyboardType.Password
        )
        Spacer(Modifier.height(42.dp))

        SingleLineTextField(
            text = uiModel.passwordConfirm,
            onTextChange = {
                onValueChange(uiModel.copy(passwordConfirm = it))
            },
            isError = passwordConfirmResult is SignUpInfoResult.Fail,
            errorMessage = passwordConfirmResult.toErrorMessageOrNull(),
            label = R.string.sign_up_input_user_password_confirm,
            keyBoardType = KeyboardType.Password
        )
        Spacer(Modifier.height(42.dp))

        SignUpButton(
            enable = SignUpForm(
                userNameResult,
                emailResult,
                passwordResult,
                passwordConfirmResult
            ).canSubmit(),
        )
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
)
@Composable
private fun SignUpPreview() {
    val (signUpInfo, onSignUpInfoChange) = remember {
        mutableStateOf(
            SignUpUiModel()
        )
    }
    SignUpScreen(signUpInfo, onSignUpInfoChange)
}
