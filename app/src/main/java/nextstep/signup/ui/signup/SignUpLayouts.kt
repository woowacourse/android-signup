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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import nextstep.signup.R
import nextstep.signup.domain.Email
import nextstep.signup.domain.Password
import nextstep.signup.domain.PasswordConfirm
import nextstep.signup.domain.Username
import nextstep.signup.ui.theme.SignUpTheme

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
fun SignUpInteractionLayer(onButtonClicked: () -> Unit) {
    var username by remember { mutableStateOf(Username()) }
    var email by remember { mutableStateOf(Email()) }
    var password by remember { mutableStateOf(Password()) }
    var passwordConfirm by remember { mutableStateOf(PasswordConfirm()) }
    val isFormatValid by remember {
        derivedStateOf {
            username.isValid && email.isValid && password.isValid && passwordConfirm.isMatchWithPassword(password.value)
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
            onPasswordConfirmChanged = { passwordConfirm = passwordConfirm.copy(value = it) },
        )
        SignUpButton(
            modifier = modifier.requiredHeight(50.dp),
            isSignUpAvailiable = isFormatValid,
            onButtonClicked = onButtonClicked,
        )
    }
}

@Composable
fun SignUpInputs(
    modifier: Modifier = Modifier,
    username: Username,
    email: Email,
    password: Password,
    passwordConfirm: PasswordConfirm,
    onUsernameChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onPasswordConfirmChanged: (String) -> Unit,
) {
    UsernameInput(
        modifier = modifier,
        username = username,
        onUsernameChanged = onUsernameChanged,
    )
    EmailInput(
        modifier = modifier,
        email = email,
        onEmailChanged = onEmailChanged,
    )
    PasswordInput(
        modifier = modifier,
        password = password,
        onPasswordChanged = onPasswordChanged,
    )
    PasswordConfirmInput(
        modifier = modifier,
        password = password,
        passwordConfirm = passwordConfirm,
        onPasswordConfirmChanged = onPasswordConfirmChanged,
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
