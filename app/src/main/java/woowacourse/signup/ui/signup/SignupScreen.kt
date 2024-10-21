package woowacourse.signup.ui.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import woowacourse.signup.R
import woowacourse.signup.ui.component.SignupButton
import woowacourse.signup.ui.component.SignupTextField
import woowacourse.signup.ui.signup.model.EmailUiModel
import woowacourse.signup.ui.signup.model.PasswordConfirmUiModel
import woowacourse.signup.ui.signup.model.PasswordUiModel
import woowacourse.signup.ui.signup.model.UserNameUiModel
import woowacourse.signup.ui.theme.SignupTheme
import woowacourse.signup.ui.theme.Typography

@Composable
fun SignupScreen() {
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()
    val localContextResource = LocalContext.current.resources

    val onShowJoinSnackbar: () -> Unit = {
        coroutineScope.launch {
            snackbarHostState.showSnackbar(localContextResource.getString(R.string.complete_join))
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) { contentPadding ->
        SignupContent(
            modifier = Modifier.padding(contentPadding),
            onShowJoinSnackbar = onShowJoinSnackbar,
        )
    }
}

@Composable
private fun SignupContent(
    modifier: Modifier = Modifier,
    onShowJoinSnackbar: () -> Unit,
) {
    var userName by remember { mutableStateOf(UserNameUiModel()) }
    var email by remember { mutableStateOf(EmailUiModel()) }
    var password by remember { mutableStateOf(PasswordUiModel()) }
    var passwordConfirm by remember { mutableStateOf(PasswordConfirmUiModel()) }

    val buttonEnabled = !(userName.isError() || email.isError() || password.isError() || passwordConfirm.isError(password))
    val localContextResource = LocalContext.current.resources

    Column(
        modifier =
            modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
    ) {
        Text(
            text = stringResource(id = R.string.sign_up_title),
            style = Typography.titleLarge,
            modifier =
                Modifier
                    .padding(top = 60.dp, bottom = 14.dp)
                    .fillMaxWidth(),
        )
        SignupTextField(
            modifier = Modifier.padding(top = 16.dp),
            labelText = stringResource(id = R.string.username_input),
            inputValue = userName.value,
            isError = userName.isError(),
            errorText = userName.errorMessage(localContextResource),
        ) {
            userName = UserNameUiModel(it)
        }
        SignupTextField(
            modifier = Modifier.padding(top = 16.dp),
            labelText = stringResource(id = R.string.email_input),
            inputValue = email.value,
            isError = email.isError(),
            errorText = email.errorMessage(localContextResource),
        ) {
            email = EmailUiModel(it)
        }
        SignupTextField(
            modifier = Modifier.padding(top = 16.dp),
            labelText = stringResource(id = R.string.password_input),
            inputValue = password.value,
            isError = password.isError(),
            errorText = password.errorMessage(localContextResource),
            visualTransformation = PasswordVisualTransformation(),
        ) {
            password = PasswordUiModel(it)
        }
        SignupTextField(
            modifier = Modifier.padding(top = 16.dp),
            labelText = stringResource(id = R.string.password_confirm_input),
            inputValue = passwordConfirm.value,
            isError = passwordConfirm.isError(password),
            errorText = passwordConfirm.errorMessage(localContextResource, password),
            visualTransformation = PasswordVisualTransformation(),
        ) {
            passwordConfirm = PasswordConfirmUiModel(it)
        }
        SignupButton(
            modifier = Modifier.padding(top = 22.dp),
            text = stringResource(id = R.string.sign_up_button),
            enabled = buttonEnabled,
        ) {
            onShowJoinSnackbar()
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MainActivityPreview() {
    SignupTheme {
        SignupScreen()
    }
}
