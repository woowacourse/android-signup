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

        val isPasswordSame = password.value == passwordConfirm.value
        val enabled =
            userName.value.isNotBlank() &&
                    email.value.isNotBlank() &&
                    password.value.isNotBlank() &&
                    passwordConfirm.value.isNotBlank() &&
                    isPasswordSame

        Text(
            modifier = Modifier.padding(bottom = 42.dp),
            text = stringResource(id = R.string.welcome),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
        )
        SignUpTextField(
            modifier = Modifier.padding(bottom = 36.dp),
            label = stringResource(id = R.string.user_name),
            text = userName,
            onValueChange = { userName.value = it },
        )
        SignUpTextField(
            modifier = Modifier.padding(bottom = 36.dp),
            label = stringResource(id = R.string.email),
            text = email,
            onValueChange = { email.value = it },
        )
        SignUpPasswordTextField(
            modifier = Modifier.padding(bottom = 36.dp),
            label = stringResource(id = R.string.password),
            text = password,
            onValueChange = { password.value = it },
        )
        SignUpPasswordTextField(
            modifier = Modifier.padding(bottom = 42.dp),
            label = stringResource(id = R.string.password_confirm),
            text = passwordConfirm,
            onValueChange = { passwordConfirm.value = it },
        )
        ConfirmButton(
            modifier = Modifier.fillMaxWidth(),
            enabled = enabled,
            text = stringResource(id = R.string.signup),
        )
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
