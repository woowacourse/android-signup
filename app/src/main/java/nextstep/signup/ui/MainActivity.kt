package nextstep.signup.ui

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.R
import nextstep.signup.domain.SignUpInfo
import nextstep.signup.ui.component.SingleLineTextField
import nextstep.signup.ui.component.SubmitButton
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
                    SignUpScreen()
                }
            }
        }
    }
}

@Composable
fun SignUpScreen() {
    var signUpInfo by remember { mutableStateOf(SignUpInfo()) }
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
            text = signUpInfo.userName,
            onTextChange = {
                signUpInfo = signUpInfo.copy(userName = it)
            },
            isError = signUpInfo.isUserNameError(),
            label = stringResource(signUpInfo.userNameMessage()),
        )

        Spacer(Modifier.height(42.dp))

        SingleLineTextField(
            text = signUpInfo.email,
            onTextChange = {
                signUpInfo = signUpInfo.copy(email = it)
            },
            isError = signUpInfo.isEmailError(),
            label = stringResource(signUpInfo.emailMessage()),
            keyBoardType = KeyboardType.Email
        )

        Spacer(Modifier.height(42.dp))

        SingleLineTextField(
            text = signUpInfo.password,
            onTextChange = {
                signUpInfo = signUpInfo.copy(password = it)
            },
            modifier = Modifier.fillMaxWidth(),
            isError = signUpInfo.isPasswordError(),
            label = stringResource(signUpInfo.passwordMessage()),
            keyBoardType = KeyboardType.Password
        )
        Spacer(Modifier.height(42.dp))

        SingleLineTextField(
            text = signUpInfo.passwordConfirm,
            onTextChange = {
                signUpInfo = signUpInfo.copy(passwordConfirm = it)
            },
            isError = signUpInfo.isPasswordConfirmError(),
            label = stringResource(signUpInfo.passwordConfirmMessage()),
            keyBoardType = KeyboardType.Password
        )
        Spacer(Modifier.height(42.dp))

        SubmitButton(
            text = stringResource(R.string.sign_up_submit_btn),
            onClick = {},
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
    SignUpScreen()
}