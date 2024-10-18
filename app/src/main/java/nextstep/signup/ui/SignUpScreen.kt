package nextstep.signup.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import nextstep.signup.R
import nextstep.signup.ui.model.UserForm

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    userForm: UserForm = UserForm(),
) {
    var signUpForm: UserForm by rememberSaveable { mutableStateOf(userForm) }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Scaffold(
        modifier = modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) { paddingValues ->
        SignUpForm(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(paddingValues),
            userForm = signUpForm,
            onSignUpFormChange = { changedValue ->
                signUpForm = changedValue
            },
            onConfirm = {
                scope.launch {
                    snackbarHostState.showSnackbar(
                        message = context.getString(R.string.signup_complete_message),
                        duration = SnackbarDuration.Short,
                    )
                }
            },
        )
    }
}

@Preview
@Composable
private fun SignUpScreenPreview() {
    SignUpScreen()
}
