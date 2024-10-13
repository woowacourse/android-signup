package nextstep.signup

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
    val name = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val passwordConfirm = remember { mutableStateOf("") }
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
            text = name.value,
            onTextChange = {
                name.value = it
            },
            modifier = Modifier.fillMaxWidth(),
            hint = stringResource(R.string.sign_up_input_user_name),
        )

        Spacer(Modifier.height(42.dp))

        SingleLineTextField(
            text = email.value,
            onTextChange = {
                email.value = it
            },
            modifier = Modifier.fillMaxWidth(),
            hint = stringResource(R.string.sign_up_input_user_email),
            keyBoardType = KeyboardType.Email
        )

        Spacer(Modifier.height(42.dp))

        SingleLineTextField(
            text = password.value,
            onTextChange = {
                password.value = it
            },
            modifier = Modifier.fillMaxWidth(),
            hint = stringResource(R.string.sign_up_input_user_password),
            keyBoardType = KeyboardType.Password
        )
        Spacer(Modifier.height(42.dp))

        SingleLineTextField(
            text = passwordConfirm.value,
            onTextChange = {
                passwordConfirm.value = it
            },
            modifier = Modifier.fillMaxWidth(),
            hint = stringResource(R.string.sign_up_input_user_password_confirm),
            keyBoardType = KeyboardType.Password
        )
        Spacer(Modifier.height(42.dp))

        SubmitButton(
            text = stringResource(R.string.sign_up_submit_btn),
            onClick = {},
            modifier = Modifier.fillMaxWidth()
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
