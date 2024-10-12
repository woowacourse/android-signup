package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.ui.component.InputText
import nextstep.signup.ui.component.TextButton
import nextstep.signup.ui.component.TitleText
import nextstep.signup.ui.theme.SignupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupTheme(dynamicColor = false) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    SignUpComponent()
                }
            }
        }
    }
}

@Composable
fun SignUpComponent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        TitleText(R.string.sign_up_title)
        InputText(R.string.sign_up_user_name_title)
        InputText(R.string.sign_up_email_title, KeyboardType.Email)
        InputText(
            R.string.sign_up_password_title,
            KeyboardType.Password,
            PasswordVisualTransformation(),
        )
        InputText(
            R.string.sign_up_password_confirm_title,
            KeyboardType.Password,
            PasswordVisualTransformation(),
        )
        TextButton(R.string.sign_up_button_title)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpPreview() {
    SignupTheme {
        SignUpComponent()
    }
}
