package nextstep.signup.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import nextstep.signup.R

@Composable
fun SignUpScreen() {
    var formState by remember { mutableStateOf(SignUpFormState()) }

    val signUpSuccessMessage = stringResource(R.string.sign_up_success)

    val isButtonEnabled = canClickedButton(formState)

    val snackBarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(snackbarHost = { SnackbarHost(hostState = snackBarHostState) }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
        ) {
            SignUpLabel()
            SignUpForm(
                formState = formState,
                onFieldChange = { field, value ->
                    formState = formState.updateField(field, value)
                }
            )
            SignUpButton(
                isButtonEnabled = isButtonEnabled,
                onSignUpSuccess = {
                    coroutineScope.launch {
                        snackBarHostState.showSnackbar(message = signUpSuccessMessage)
                    }
                }
            )
        }
    }
}

@Composable
private fun canClickedButton(formState: SignUpFormState): Boolean {
    return formState.userNameError.isEmpty() &&
        formState.emailError.isEmpty() &&
        formState.passwordError.isEmpty() &&
        formState.passwordConfirmError.isEmpty() &&
        formState.userName.isNotEmpty() &&
        formState.email.isNotEmpty() &&
        formState.password.isNotEmpty() &&
        formState.passwordConfirm.isNotEmpty()
}

@Composable
fun SignUpLabel() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(36.dp)
    ) {
        Text(
            text = stringResource(R.string.title),
            modifier = Modifier.align(Alignment.Center),
            style = MaterialTheme.typography.headlineMedium
        )
    }
}

@Composable
fun SignUpForm(
    formState: SignUpFormState,
    onFieldChange: (FieldType, String) -> Unit
) {
    Column {
        CustomTextField(
            value = formState.userName,
            onValueChange = { onFieldChange(FieldType.USERNAME, it) },
            label = stringResource(R.string.username),
            isError = formState.userNameError.isNotEmpty(),
            errorMessage = formState.userNameError
        )

        CustomTextField(
            value = formState.email,
            onValueChange = { onFieldChange(FieldType.EMAIL, it) },
            label = stringResource(R.string.email),
            isError = formState.emailError.isNotEmpty(),
            errorMessage = formState.emailError
        )

        CustomTextField(
            value = formState.password,
            onValueChange = { onFieldChange(FieldType.PASSWORD, it) },
            label = stringResource(R.string.password),
            isPasswordField = true,
            isError = formState.passwordError.isNotEmpty(),
            errorMessage = formState.passwordError
        )

        CustomTextField(
            value = formState.passwordConfirm,
            onValueChange = { onFieldChange(FieldType.PASSWORD_CONFIRM, it) },
            label = stringResource(R.string.password_confirm),
            isPasswordField = true,
            isError = formState.passwordConfirmError.isNotEmpty(),
            errorMessage = formState.passwordConfirmError
        )
    }
}

@Composable
fun SignUpButton(isButtonEnabled: Boolean, onSignUpSuccess: () -> Unit) {
    Button(
        onClick = {
            onSignUpSuccess()
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(36.dp),
        enabled = isButtonEnabled
    ) {
        Text(text = stringResource(R.string.sign_up))
    }
}

@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    isPasswordField: Boolean = false,
    isError: Boolean = false,
    errorMessage: String = ""
) {
    Column {
        TextField(
            value = value,
            onValueChange = onValueChange,
            label = { Text(label) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp, vertical = 18.dp),
            visualTransformation = if (isPasswordField) PasswordVisualTransformation() else VisualTransformation.None,
            isError = isError
        )
        if (isError) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier.padding(start = 24.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewSignUpScreen() {
    SignUpScreen()
}
