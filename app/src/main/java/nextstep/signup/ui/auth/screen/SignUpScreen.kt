package nextstep.signup.ui.auth.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import nextstep.signup.R
import nextstep.signup.ui.auth.component.SignUpForm
import nextstep.signup.ui.auth.model.SignUpFormState
import nextstep.signup.ui.auth.preview.SignUpPreviewParamsProvider
import nextstep.signup.ui.interaction.clearFocusWith
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun SignUpScreen() {
    var formState by rememberSaveable {
        mutableStateOf(SignUpFormState("", "", "", ""))
    }
    val onSignUpFormStateChange: (SignUpFormState) -> Unit = { new: SignUpFormState ->
        formState = new
    }
    val onEmailChange = { newEmail: String ->
        onSignUpFormStateChange(formState.copy(email = newEmail))
    }
    val onUserNameChange = { newUserName: String ->
        onSignUpFormStateChange(formState.copy(userName = newUserName))
    }
    val onPasswordChange = { newPassword: String ->
        onSignUpFormStateChange(formState.copy(password = newPassword))
    }
    val onPasswordConfirmChange = { newPasswordConfirm: String ->
        onSignUpFormStateChange(formState.copy(passwordConfirm = newPasswordConfirm))
    }
    val enableSignUp by remember {
        derivedStateOf {
            formState.enableSignUp
        }
    }
    val snackbarHostState = SnackbarHostState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->
        val completeMessage = stringResource(id = R.string.sign_up_success)
        val onDone: () -> Unit = remember {
            {
                coroutineScope.launch {
                    snackbarHostState.showSnackbar(completeMessage)
                }
            }
        }
        SignUpScreen(
            modifier = Modifier.padding(innerPadding),
            signUpFormState = formState,
            onUserNameChange = onUserNameChange,
            onEmailChange = onEmailChange,
            onPasswordChange = onPasswordChange,
            onPasswordConfirmChange = onPasswordConfirmChange,
            onDoneSignUp = onDone
        )
    }
}

@Composable
internal fun SignUpScreen(
    modifier: Modifier = Modifier,
    signUpFormState: SignUpFormState,
    onUserNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onPasswordConfirmChange: (String) -> Unit,
    onDoneSignUp: () -> Unit
) {
    val enableSignUp by remember(signUpFormState) {
        derivedStateOf { signUpFormState.enableSignUp }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .clearFocusWith(LocalFocusManager.current)
            .padding(top = 30.dp)
            .padding(horizontal = 36.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SignUpTitle()
        Spacer(modifier = Modifier.height(25.dp))
        SignUpForm(
            signUpFormState = signUpFormState,
            onUserNameChange = onUserNameChange,
            onEmailChange = onEmailChange,
            onPasswordChange = onPasswordChange,
            onPasswordConfirmChange = onPasswordConfirmChange,
            onDoneSignUp = onDoneSignUp
        )
        Spacer(modifier = Modifier.height(16.dp))
        SignUpConfirmButton(onDoneSignUp, enableSignUp)
    }
}

@Composable
private fun SignUpTitle() {
    Text(
        text = stringResource(id = R.string.sign_up_title),
        style = MaterialTheme.typography.titleLarge.copy(
            fontWeight = FontWeight.Bold
        )
    )
}

@Composable
private fun SignUpConfirmButton(onClickSignUp: () -> Unit, enableSignUp: Boolean) {
    Button(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = { onClickSignUp() },
        enabled = enableSignUp
    ) {
        Text(
            modifier = Modifier.padding(vertical = 6.dp),
            text = stringResource(id = R.string.sign_up_confirm_button),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(name = "enabled")
@Composable
private fun PreviewSignUpConfirmButton() {
    SignupTheme {
        Surface {
            SignUpConfirmButton({}, true)
        }
    }
}

@Preview(name = "disabled")
@Composable
private fun PreviewSignUpConfirmButton2() {
    SignupTheme {
        Surface {
            SignUpConfirmButton({}, false)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun Preview1() {
    SignupTheme {
        SignUpScreen()
    }
}

@Preview(showSystemUi = true)
@Composable
private fun Preview2(@PreviewParameter(SignUpPreviewParamsProvider::class) state: SignUpFormState) {
    SignupTheme {
        SignUpScreen(
            signUpFormState = state,
            onUserNameChange = {},
            onEmailChange = {},
            onPasswordChange = {},
            onPasswordConfirmChange = {},
            onDoneSignUp = {},
        )
    }
}
