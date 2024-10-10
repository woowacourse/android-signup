package nextstep.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.signup.ui.theme.Black30
import nextstep.signup.ui.theme.Blue50
import nextstep.signup.ui.theme.BlueGrey20
import nextstep.signup.ui.theme.PurpleGrey40

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

@Composable
fun SignUpHeader(modifier: Modifier = Modifier) {
    Text(
        text = "Welcome to Compose 🚀",
        style = TextStyle(
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif
        ),
        modifier = modifier
    )
}

@Composable
fun SignUpTextField(
    modifier: Modifier = Modifier,
    labelText: String = "Enter Text",
    visualTransformation: VisualTransformation = VisualTransformation.None,
    value: String = "",
    onValueChange: (String) -> Unit = { value }
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        maxLines = 1,
        label = { Text(text = labelText) },
        modifier = modifier,
        visualTransformation = visualTransformation,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Blue50,
            unfocusedIndicatorColor = Black30,
            focusedLabelColor = Blue50,
            unfocusedLabelColor = Black30,
            focusedContainerColor = BlueGrey20,
            unfocusedContainerColor = BlueGrey20,
            errorContainerColor = Color.Red,
            disabledContainerColor = PurpleGrey40,
        )
    )
}

@Composable
fun SignUpButton(
    modifier: Modifier = Modifier,
    enable: () -> Boolean = { true }
) {
    val enabled = remember { mutableStateOf(true) }
    Button(
        onClick = {
            enabled.value = !enabled.value
        },
        enabled = enable(),
        modifier = modifier.then(Modifier.fillMaxWidth())
    ) {
        Text(
            text = "Sign Up",
            fontSize = 14.sp
        )
    }
}

@Preview
@Composable
private fun SignUpScreenPreview() {
    SignUpScreen()
}

@Preview
@Composable
private fun SignUpHeaderPreview() {
    SignUpHeader()
}

@Preview
@Composable
private fun SignUpTextFieldPreview() {
    SignUpTextField()
}

@Preview
@Composable
private fun SignUpButtonPreview() {
    SignUpButton()
}
