package nextstep.signup.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.signup.R
import nextstep.signup.ui.model.SignUpStatus
import nextstep.signup.ui.model.UserForm
import nextstep.signup.ui.theme.Typography

@Composable
fun SignUpForm(
    modifier: Modifier = Modifier,
    userForm: UserForm,
    onSignUpFormChange: (UserForm) -> Unit,
    onConfirm: () -> Unit,
) {
    val scrollState = rememberScrollState()

    Column(
        modifier =
        modifier
            .verticalScroll(scrollState)
            .padding(horizontal = 32.dp, vertical = 60.dp),
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.signup_greeting),
            style = Typography.titleLarge,
        )

        SignUpFormTextFields(
            modifier =
            Modifier
                .fillMaxWidth()
                .padding(vertical = 40.dp),
            userForm = userForm,
            onSignUpFormChange = onSignUpFormChange,
        )

        DefaultButton(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.signup_button_signup),
            fontSize = 14.sp,
            enabled = userForm.formValid,
            onClick = onConfirm,
        )
    }
}

@Composable
private fun SignUpFormTextFields(
    modifier: Modifier = Modifier,
    userForm: UserForm,
    onSignUpFormChange: (UserForm) -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        val usernameErrorMessageId = userForm.errorMessageResourceOf(UserForm.FormField.USERNAME)
        val emailErrorMessageId = userForm.errorMessageResourceOf(UserForm.FormField.EMAIL)
        val passwordErrorMessageId = userForm.errorMessageResourceOf(UserForm.FormField.PASSWORD)
        val passwordConfirmationErrorMessageId =
            userForm.errorMessageResourceOf(UserForm.FormField.PASSWORD_CONFIRMATION)

        PlainTextField(
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(id = R.string.signup_label_username),
            value = userForm.username,
            isError = userForm.hasError(UserForm.FormField.USERNAME),
            errorMessage = usernameErrorMessageId?.let { stringResource(id = it) },
            onValueChange = { changedValue ->
                onSignUpFormChange(userForm.copy(username = changedValue))
            },
        )

        EmailTextField(
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(id = R.string.signup_label_email),
            value = userForm.email,
            isError = userForm.hasError(UserForm.FormField.EMAIL),
            errorMessage = emailErrorMessageId?.let { stringResource(id = it) },
            onValueChange = { changedValue ->
                onSignUpFormChange(userForm.copy(email = changedValue))
            },
        )

        PasswordTextField(
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(id = R.string.signup_label_password),
            value = userForm.password,
            isError = userForm.hasError(UserForm.FormField.PASSWORD),
            errorMessage = passwordErrorMessageId?.let { stringResource(id = it) },
            onValueChange = { changedValue ->
                onSignUpFormChange(userForm.copy(password = changedValue))
            },
        )

        PasswordTextField(
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(id = R.string.signup_label_password_confirm),
            value = userForm.passwordConfirmation,
            isError = userForm.hasError(UserForm.FormField.PASSWORD_CONFIRMATION),
            errorMessage = passwordConfirmationErrorMessageId?.let { stringResource(id = it) },
            onValueChange = { changedValue ->
                onSignUpFormChange(userForm.copy(passwordConfirmation = changedValue))
            },
        )
    }
}

@Preview
@Composable
private fun SignUpFormPreview() {
    var signUpForm: UserForm by rememberSaveable {
        mutableStateOf(UserForm())
    }

    SignUpForm(
        modifier = Modifier.fillMaxWidth(),
        userForm = signUpForm,
        onSignUpFormChange = { changedValue -> signUpForm = changedValue },
        onConfirm = {},
    )
}
