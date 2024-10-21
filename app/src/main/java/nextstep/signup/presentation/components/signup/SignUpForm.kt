package nextstep.signup.presentation.components.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.R
import nextstep.signup.domain.Email
import nextstep.signup.domain.SignUp
import nextstep.signup.domain.Username
import nextstep.signup.ui.model.ErrorMessage

@Composable
fun SignUpForm(
    signUpData: SignUp,
    onDataChange: (SignUp) -> Unit = {},
    onClick: () -> Unit = {}
) {
    var showSnackbar by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(32.dp)
    ) {
        Spacer(modifier = Modifier.padding(top = 80.dp))

        SignUpGreeting()

        // Username Input
        SignUpTextField(
            value = signUpData.username.name,
            onValueChange = {
                onDataChange(
                    signUpData.copy(
                        username = Username(it)
                    )
                )
            },
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(R.string.sign_up_form_username),
            errorMessage = ErrorMessage(signUpData.password.error).message
        )

        // Email Input
        SignUpTextField(
            value = signUpData.email.address,
            onValueChange = {
                onDataChange(
                    signUpData.copy(
                        email = Email(it)
                    )
                )
            },
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(R.string.sign_up_form_email),
            errorMessage = ErrorMessage(signUpData.password.error).message
        )

        // Password Input
        SignUpTextField(
            value = signUpData.password.value,
            onValueChange = {
                onDataChange(
                    signUpData.copy(
                        password = signUpData.password.copy(
                            value = it
                        )
                    )
                )
            },
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(R.string.sign_up_form_password),
            isPassword = true,
            errorMessage = ErrorMessage(signUpData.password.error).message
        )

        // Password Confirm Input
        SignUpTextField(
            value = signUpData.confirmPassword.value,
            onValueChange = {
                onDataChange(
                    signUpData.copy(
                        confirmPassword = signUpData.confirmPassword.copy(
                            value = it
                        )
                    )
                )
            },
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(R.string.sign_up_form_password_confirm),
            isPassword = true,
            errorMessage = ErrorMessage(signUpData.password.error).message
        )

        // Sign Up Button
        SignUpButton(
            availability = (
                { signUpData.isValid() }
                ),
            onClick = {
                onClick()
                showSnackbar = true
            },
            modifier = Modifier.fillMaxWidth()
        )

        if (showSnackbar) {
            SignUpSnackbar(
                message = "회원가입 완료",
                onDismiss = {
                    onDataChange(SignUp.BLANK_SIGN_UP)
                    showSnackbar = false
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SignUpFormPreview() {
    SignUpForm(
        SignUp.BLANK_SIGN_UP
    )
}
