package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.ui.ButtonView
import nextstep.signup.ui.TextFieldView
import nextstep.signup.ui.TextView
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
        TextView(stringResource(R.string.main_greeting))
        TextFieldView(paddingTop = 42.dp, label = R.string.main_user_name)
        TextFieldView(paddingTop = 36.dp, label = R.string.main_email, keyboardType = KeyboardType.Email)
        TextFieldView(paddingTop = 36.dp, label = R.string.main_password, keyboardType = KeyboardType.Password)
        TextFieldView(paddingTop = 36.dp, label = R.string.main_password_confirm, keyboardType = KeyboardType.Password)
        ButtonView(R.string.main_sign_up, paddingTop = 42.dp)
    }
}

@Preview(showBackground = true)
@Composable
private fun GreetingPreview() {
    SignupTheme {
        SignUpScreen()
    }
}
