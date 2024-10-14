package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import nextstep.signup.ui.theme.SignupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    SignUpScreen()
                }
            }
        }
    }
}

@Composable
fun SignUpScreen() {
    var username by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordConfirm by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.padding(
            start = 32.dp,
            top = 50.dp,
            end = 32.dp
        ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(36.dp)
    ) {
        HeadLine(text = stringResource(R.string.sign_up_headline))
        PlainTextField(
            value = username,
            onValueChange = { username = it },
            label = stringResource(id = R.string.sign_up_username_label)
        )
        EmailTextField(
            email = email,
            onValueChange = { email = it },
            label = stringResource(R.string.sign_up_email_label)
        )
        PasswordTextField(
            password = password,
            onValueChange = { password = it },
            label = stringResource(R.string.sign_up_password_label)
        )
        PasswordTextField(
            password = passwordConfirm,
            onValueChange = { passwordConfirm = it },
            label = stringResource(R.string.sign_up_password_confirm_label)
        )
        Spacer(modifier = Modifier.height(6.dp))
        DefaultButton(contentPadding = PaddingValues(15.dp)) {}
    }
}
