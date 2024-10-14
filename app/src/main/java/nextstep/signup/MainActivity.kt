package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.ui.component.SubjectComponent
import nextstep.signup.ui.component.SubmitButtonComponent
import nextstep.signup.ui.component.TextFieldComponent
import nextstep.signup.ui.theme.SignupTheme

private const val DEFAULT_TEXT = ""

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SignupScreen()
                }
            }
        }
    }
}

@Composable
fun SignupScreen() {
    var userName by remember { mutableStateOf(DEFAULT_TEXT) }
    var email by remember { mutableStateOf(DEFAULT_TEXT) }
    var password by remember { mutableStateOf(DEFAULT_TEXT) }
    var passwordConfirm by remember { mutableStateOf(DEFAULT_TEXT) }

    Column(
        modifier = Modifier.padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(30.dp))
        SubjectComponent(
            subject = stringResource(R.string.subject),
            emoji = stringResource(R.string.emoji)
        )
        Spacer(Modifier.height(24.dp))
        TextFieldComponent(
            textValue = userName,
            onTextChange = { newName ->
                userName = newName
            },
            labelText = stringResource(R.string.username_label)
        )
        TextFieldComponent(
            textValue = email,
            onTextChange = { newEmail ->
                email = newEmail
            },
            labelText = stringResource(R.string.email_label)
        )
        TextFieldComponent(
            textValue = password,
            onTextChange = { newPassword ->
                password = newPassword
            },
            labelText = stringResource(R.string.password_label),
            isPassword = true
        )
        TextFieldComponent(
            textValue = passwordConfirm,
            onTextChange = { newPasswordConfirm ->
                passwordConfirm = newPasswordConfirm
            },
            labelText = stringResource(R.string.password_confirm_label),
            isPassword = true
        )
        Spacer(Modifier.height(24.dp))
        SubmitButtonComponent(
            buttonText = stringResource(R.string.sign_up_button_label),
            onButtonClick = {
                // step 3 !!
            }
        )
    }
}

@Preview(
    backgroundColor = 0xFFFFFFFF,
    showBackground = true
)
@Composable
fun PreviewSignupView() {
    SignupScreen()
}
