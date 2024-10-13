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
import nextstep.signup.ui.model.SignUpFormState
import nextstep.signup.ui.theme.Typography

@Composable
fun SignUpForm(
    modifier: Modifier = Modifier,
    signUpFormState: SignUpFormState,
    onSignUpFormChange: (SignUpFormState) -> Unit,
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
            signUpFormState = signUpFormState,
            onSignUpFormChange = onSignUpFormChange,
        )

        DefaultButton(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.signup_button_signup),
            fontSize = 14.sp,
            onClick = onConfirm,
        )
    }
}

@Composable
private fun SignUpFormTextFields(
    modifier: Modifier = Modifier,
    signUpFormState: SignUpFormState,
    onSignUpFormChange: (SignUpFormState) -> Unit,
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(36.dp),
    ) {
        PlainTextField(
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(id = R.string.signup_label_username),
            value = signUpFormState.username,
            onValueChange = { changedValue ->
                onSignUpFormChange(signUpFormState.copy(username = changedValue))
            },
        )

        EmailTextField(
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(id = R.string.signup_label_email),
            value = signUpFormState.email,
            onValueChange = { changedValue ->
                onSignUpFormChange(signUpFormState.copy(email = changedValue))
            },
        )

        PasswordTextField(
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(id = R.string.signup_label_password),
            value = signUpFormState.password,
            onValueChange = { changedValue ->
                onSignUpFormChange(signUpFormState.copy(password = changedValue))
            },
        )

        PasswordTextField(
            modifier = Modifier.fillMaxWidth(),
            label = stringResource(id = R.string.signup_label_password_confirm),
            value = signUpFormState.passwordConfirmation,
            onValueChange = { changedValue ->
                onSignUpFormChange(signUpFormState.copy(passwordConfirmation = changedValue))
            },
        )
    }
}

@Preview
@Composable
private fun SignUpFormPreview() {
    var signUpForm: SignUpFormState by rememberSaveable {
        mutableStateOf(SignUpFormState())
    }

    SignUpForm(
        modifier = Modifier.fillMaxWidth(),
        signUpFormState = signUpForm,
        onSignUpFormChange = { changedValue -> signUpForm = changedValue },
        onConfirm = {},
    )
}
