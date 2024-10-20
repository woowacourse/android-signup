package nextstep.signup.ui.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import nextstep.signup.R
import nextstep.signup.domain.Email
import nextstep.signup.domain.Password
import nextstep.signup.domain.Username
import nextstep.signup.ui.common.button.StateButton
import nextstep.signup.ui.common.textfield.InputType
import nextstep.signup.ui.common.textfield.SingleLineTextInput
import nextstep.signup.ui.signup.SignUpValidator.validateEmail
import nextstep.signup.ui.signup.SignUpValidator.validatePassword
import nextstep.signup.ui.signup.SignUpValidator.validatePasswordConfirm
import nextstep.signup.ui.signup.SignUpValidator.validateUsername
import nextstep.signup.ui.theme.SignUpTheme
import nextstep.signup.ui.theme.Typography

@Composable
fun SignUpLayout() {
    val snackbarHostState by remember { mutableStateOf(SnackbarHostState()) }
    val coroutineScope = rememberCoroutineScope()
    val localContextResources = LocalContext.current.resources
    val showSignUpSuccessSnackbar: () -> Unit = {
        coroutineScope.launch {
            snackbarHostState.showSnackbar(localContextResources.getString(R.string.signup_signup_success))
        }
    }

    Column(
        modifier =
            Modifier
                .fillMaxHeight(0.7f)
                .padding(32.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SignUpTitle()
        Box {
            SignUpInteractionLayer {
                showSignUpSuccessSnackbar()
            }
            SnackbarHost(
                modifier = Modifier.align(Alignment.BottomCenter),
                hostState = snackbarHostState,
            )
        }
    }
}

@Composable
fun SignUpTitle() {
    Text(
        text = stringResource(id = R.string.signup_title),
        style = Typography.titleLarge,
    )
}

@Composable
fun SignUpInteractionLayer(onButtonClicked: () -> Unit) {
    var username by remember { mutableStateOf(Username()) }
    var email by remember { mutableStateOf(Email()) }
    var password by remember { mutableStateOf(Password()) }
    var passwordConfirm by remember { mutableStateOf("") }
    val isFormatValid by remember {
        derivedStateOf {
            username.isValid && email.isValid && password.isValid && passwordConfirm == password.value
        }
    }

    Column(
        modifier = Modifier.fillMaxHeight(0.8f),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        val modifier = Modifier.fillMaxWidth()
        SignUpInputs(
            modifier = modifier,
            username = username,
            email = email,
            password = password,
            passwordConfirm = passwordConfirm,
            onUsernameChanged = { username = username.copy(value = it) },
            onEmailChanged = { email = email.copy(value = it) },
            onPasswordChanged = { password = password.copy(value = it) },
            onPasswordConfirmChanged = { passwordConfirm = it },
        )
        StateButton(
            modifier = modifier.requiredHeight(50.dp),
            text = stringResource(id = R.string.signup_signup),
            enabled = isFormatValid,
        ) {
            onButtonClicked()
        }
    }
}

@Composable
fun SignUpInputs(
    modifier: Modifier = Modifier,
    username: Username,
    email: Email,
    password: Password,
    passwordConfirm: String,
    onUsernameChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onPasswordConfirmChanged: (String) -> Unit,
) {
    SingleLineTextInput(
        modifier = modifier,
        value = username.value,
        onValueChange = onUsernameChanged,
        label = stringResource(id = R.string.signup_username),
        inputType = InputType.Username,
        supportingText = username.validateUsername(),
    )
    SingleLineTextInput(
        modifier = modifier,
        value = email.value,
        onValueChange = onEmailChanged,
        label = stringResource(id = R.string.signup_email),
        inputType = InputType.Email,
        supportingText = email.validateEmail(),
    )
    SingleLineTextInput(
        modifier = modifier,
        value = password.value,
        onValueChange = onPasswordChanged,
        label = stringResource(id = R.string.signup_password),
        inputType = InputType.Password,
        supportingText = password.validatePassword(),
    )
    SingleLineTextInput(
        modifier = modifier,
        value = passwordConfirm,
        onValueChange = onPasswordConfirmChanged,
        label = stringResource(id = R.string.signup_password_confirm),
        inputType = InputType.Password,
        supportingText = passwordConfirm.validatePasswordConfirm(password.value),
    )
}

@Preview(showBackground = true)
@Composable
fun SignUpLayoutPreview() {
    SignUpTheme {
        Surface(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(32.dp),
        ) {
            SignUpLayout()
        }
    }
}
