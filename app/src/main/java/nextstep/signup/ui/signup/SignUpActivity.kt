package nextstep.signup.ui.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.R
import nextstep.signup.ui.signup.component.SignUpButton
import nextstep.signup.ui.signup.component.SignUpHeaderText
import nextstep.signup.ui.signup.component.SignUpTextField
import nextstep.signup.ui.theme.SignupTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    SignUpScreen()
                }
            }
        }
    }
}

@Composable
private fun SignUpScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        SignUpHeaderText(
            modifier =
                Modifier.padding(
                    start = 34.dp,
                    end = 34.dp,
                    top = 112.dp,
                    bottom = 42.dp,
                ),
            text = stringResource(R.string.sign_up_greeting),
        )
        SignUpTextFields()
        SignUpButton(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(start = 32.dp, end = 32.dp),
            text = stringResource(R.string.sign_up_button_label),
            onclick = {},
        )
    }
}

@Composable
private fun SignUpTextFields() {
    Column(
        modifier =
            Modifier
                .padding(start = 32.dp, end = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        SignUpTextField(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 36.dp),
            label = stringResource(R.string.username_label),
        )
        SignUpTextField(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 36.dp),
            label = stringResource(R.string.email_label),
            keyboardType = KeyboardType.Email,
        )
        SignUpTextField(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 36.dp),
            label = stringResource(R.string.password_label),
            keyboardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation(),
        )
        SignUpTextField(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(bottom = 42.dp),
            label = stringResource(R.string.password_confirm_label),
            keyboardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation(),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SignUpPreview() {
    SignUpScreen()
}
