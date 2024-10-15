package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.component.SignUpEmailTextField
import nextstep.signup.component.SignUpPasswordConfirmTextField
import nextstep.signup.component.SignUpPasswordTextField
import nextstep.signup.component.SignUpSubmitButton
import nextstep.signup.component.SignUpTitle
import nextstep.signup.component.SignUpUsernameTextField
import nextstep.signup.ui.theme.SignupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SignUpScreen()
                }
            }
        }
    }
}

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp, top = 22.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        SignUpTitle(title = stringResource(R.string.sign_up_title))

        SignUpUsernameTextField(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            username = "",
            onUsernameChange = { }
        )

        SignUpEmailTextField(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            email = ""
        )

        SignUpPasswordTextField(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            password = ""
        )

        SignUpPasswordConfirmTextField(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            passwordConfirm = ""
        )


        SignUpSubmitButton(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp),
            text = stringResource(R.string.button_sign_up),
            onClick = { }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignupTheme {
        SignUpScreen()
    }
}
