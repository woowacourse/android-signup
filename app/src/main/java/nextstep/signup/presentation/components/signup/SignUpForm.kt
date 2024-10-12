package nextstep.signup.presentation.components.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SignUpForm() {
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        Spacer(modifier = Modifier.padding(top = 80.dp))

        SignUpGreeting()

        // Username Input
        SignUpTextField(value = username, onValueChange = { username = it }, label = "Username")

        // Email Input
        SignUpTextField(value = email, onValueChange = { email = it }, label = "Email")

        // Password Input
        SignUpTextField(value = password, onValueChange = { password = it }, label = "Password", isPassword = true)

        // Password Confirm Input
        SignUpTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = "Password Confirm",
            isPassword = true
        )

        // Sign Up Button
        SignUpButton(
            availability = (
                {
                    username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty() &&
                        password == confirmPassword
                }
                )
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SignUpFormPreview() {
    SignUpForm()
}
