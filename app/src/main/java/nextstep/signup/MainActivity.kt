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
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import nextstep.signup.components.DefaultButton
import nextstep.signup.components.EmailTextField
import nextstep.signup.components.HeadLine
import nextstep.signup.components.PasswordTextField
import nextstep.signup.components.UsernameTextField
import nextstep.signup.state.EmailState
import nextstep.signup.state.InputValidationResult.Valid
import nextstep.signup.state.PasswordConfirmState
import nextstep.signup.state.PasswordState
import nextstep.signup.state.UsernameState
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
    var usernameState by remember { mutableStateOf(UsernameState()) }
    var emailState by remember { mutableStateOf(EmailState()) }
    var passwordState by remember { mutableStateOf(PasswordState()) }
    var passwordConfirmState by remember { mutableStateOf(PasswordConfirmState()) }
    val isSignUpEnabled by remember {
        derivedStateOf {
            usernameState.validate() == Valid &&
                    emailState.validate() == Valid &&
                    passwordState.validate() == Valid &&
                    passwordConfirmState.validate(passwordState.password) == Valid
        }
    }

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
        UsernameTextField(
            value = usernameState.username,
            onValueChange = { usernameState = usernameState.copy(username = it) },
            label = stringResource(id = R.string.sign_up_username_label),
            inputValidationResult = usernameState.validate()
        )
        EmailTextField(
            email = emailState.email,
            onValueChange = { emailState = emailState.copy(email = it) },
            label = stringResource(R.string.sign_up_email_label),
            inputValidationResult = emailState.validate()
        )
        PasswordTextField(
            password = passwordState.password,
            onValueChange = { passwordState = passwordState.copy(password = it) },
            label = stringResource(R.string.sign_up_password_label),
            inputValidationResult = passwordState.validate()
        )
        PasswordTextField(
            password = passwordConfirmState.password,
            onValueChange = { passwordConfirmState = passwordConfirmState.copy(password = it) },
            label = stringResource(R.string.sign_up_password_confirm_label),
            inputValidationResult = passwordConfirmState.validate(passwordState.password)
        )
        Spacer(modifier = Modifier.height(6.dp))
        DefaultButton(
            contentPadding = PaddingValues(15.dp),
            enabled = isSignUpEnabled
        ) {}
    }
}
