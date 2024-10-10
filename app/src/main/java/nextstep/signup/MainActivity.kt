package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.signup.ui.theme.SignupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupTheme {
                SignUpScreen()
            }
        }
    }
}

@Composable
private fun SignUpScreen() {
    Surface {
        Column(modifier = Modifier.fillMaxWidth()) {
            SignUpLabel()
            SignUpTotal()
            SignUpButton()
        }
    }
}

@Composable
fun SignUpLabel() {
    Box(
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(
            text = stringResource(R.string.title),
            modifier =
            Modifier
                .align(Alignment.Center),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun SignUpTotal() {
    var userName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordConfirm by remember { mutableStateOf("") }

    Column {
        TextField(
            value = userName,
            modifier =
            Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
            onValueChange = { userName = it },
            label = { Text(stringResource(R.string.username)) }
        )

        TextField(
            value = email,
            modifier =
            Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
            onValueChange = { email = it },
            label = { Text(stringResource(R.string.email)) }
        )
        TextField(
            value = password,
            modifier =
            Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
            onValueChange = { password = it },
            label = { Text(stringResource(R.string.password)) },
            visualTransformation = PasswordVisualTransformation()
        )
        TextField(
            value = passwordConfirm,
            modifier =
            Modifier
                .fillMaxWidth()
                .padding(all = 16.dp),
            onValueChange = { passwordConfirm = it },
            label = { Text(stringResource(R.string.password_confirm)) },
            visualTransformation = PasswordVisualTransformation(),
        )
    }
}

@Composable
private fun SignUpButton() {
    Button(
        onClick = { /* Sign up logic */ },
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(all = 16.dp)
    ) {
        Text(text = stringResource(R.string.sign_up))
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    SignupTheme {
        SignUpScreen()
    }
}
