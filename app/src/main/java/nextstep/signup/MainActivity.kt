package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.ui.ButtonComponent
import nextstep.signup.ui.TextComponent
import nextstep.signup.ui.TextFieldComponent
import nextstep.signup.ui.theme.SignupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SignupTheme {
                Surface(
                    modifier =
                        Modifier
                            .fillMaxSize()
                            .padding(top = 56.dp, start = 32.dp, end = 32.dp),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    SignUpScreen()
                }
            }
        }
    }
}

@Composable
fun SignUpScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextComponent(stringResource(R.string.main_greeting))
        Spacer(modifier = Modifier.size(42.dp))

        TextFieldComponent(label = R.string.main_user_name)
        Spacer(modifier = Modifier.size(36.dp))

        TextFieldComponent(label = R.string.main_email, keyboardType = KeyboardType.Email)
        Spacer(modifier = Modifier.size(36.dp))

        TextFieldComponent(label = R.string.main_password, keyboardType = KeyboardType.Password)
        Spacer(modifier = Modifier.size(36.dp))

        TextFieldComponent(label = R.string.main_password_confirm, keyboardType = KeyboardType.Password)
        Spacer(modifier = Modifier.size(42.dp))

        ButtonComponent(R.string.main_sign_up)
    }
}

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    SignupTheme {
        SignUpScreen()
    }
}
