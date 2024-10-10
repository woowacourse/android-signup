package nextstep.signup.presentation.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SignUpScreen(modifier: Modifier = Modifier) {
    var userName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordConfirmed by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SignUpHeader()

        Spacer(modifier = Modifier.height(24.dp))

        SignUpTextField(
            labelText = "Username",
            value = userName,
            onValueChange = { userName = it },
            modifier = modifier.then(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        SignUpTextField(
            labelText = "Email",
            value = email,
            onValueChange = { email = it },
            modifier = modifier.then(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        SignUpTextField(
            labelText = "Password",
            visualTransformation = PasswordVisualTransformation(),
            value = password,
            onValueChange = { password = it },
            modifier = modifier.then(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        SignUpTextField(
            labelText = "Password Confirm",
            visualTransformation = PasswordVisualTransformation(),
            value = passwordConfirmed,
            onValueChange = { passwordConfirmed = it },
            modifier = modifier.then(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        SignUpButton(
            enable = {
                email.isNotEmpty() && userName.isNotEmpty() &&
                        password.isNotEmpty() && passwordConfirmed.isNotEmpty() && password == passwordConfirmed
            },
            modifier = modifier.then(
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            )
        )
    }
}


@Preview
@Composable
private fun SignUpScreenPreview() {
    SignUpScreen()
}



