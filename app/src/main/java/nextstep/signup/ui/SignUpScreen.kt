package nextstep.signup.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.ui.model.SignUpFormState

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
) {
    var signUpForm: SignUpFormState by rememberSaveable { mutableStateOf(SignUpFormState()) }

    Scaffold(
        modifier = modifier,
    ) { paddingValues ->
        SignUpForm(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            signUpFormState = signUpForm,
            onSignUpFormChange = { changedValue -> signUpForm = changedValue },
            onConfirm = { /* To-Be Implemented */ },
        )
    }
}

@Preview
@Composable
private fun SignUpScreenPreview() {
    SignUpScreen(modifier = Modifier.fillMaxSize())
}
