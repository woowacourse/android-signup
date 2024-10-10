package nextstep.signup.ui.signupform

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.signup.R
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun SignUpScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val userName = remember { mutableStateOf("") }
        val email = remember { mutableStateOf("") }
        val password = remember { mutableStateOf("") }
        val passwordConfirm = remember { mutableStateOf("") }

        Text(
            text = stringResource(id = R.string.welcome),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 42.dp),
        )
        SignUpTextField(
            label = stringResource(id = R.string.user_name),
            text = userName,
            onValueChange = {userName.value = it},
            modifier = Modifier.padding(bottom = 36.dp),
        )
        SignUpTextField(
            label = stringResource(id = R.string.email),
            text = email,
            onValueChange = {email.value = it},
            modifier = Modifier.padding(bottom = 36.dp),
        )
        SignUpPasswordTextField(
            label = stringResource(id = R.string.password),
            text = password,
            onValueChange = {password.value = it},
            modifier = Modifier.padding(bottom = 36.dp),
        )
        SignUpPasswordTextField(
            label = stringResource(id = R.string.password_confirm),
            text = passwordConfirm,
            onValueChange = {passwordConfirm.value = it},
            modifier = Modifier.padding(bottom = 42.dp),
        )
        ConfirmButton(stringResource(id = R.string.signup), modifier = Modifier.fillMaxWidth())
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun SignUpFormScreen() {
    SignupTheme {
        SignUpScreen()
    }
}
