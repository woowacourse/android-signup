package nextstep.signup.presentation.signup

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.R
import nextstep.signup.domain.SignUpResult
import nextstep.signup.ui.theme.SignupTheme
import nextstep.signup.ui.theme.Typography

@Composable
fun SignUpButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    signUpResult: SignUpResult,
    text: String = stringResource(R.string.sign_up_button)
) {
    Button(
        onClick = { onClick() },
        enabled = signUpResult is SignUpResult.Success,
        modifier = modifier
    ) {
        Text(
            text = text,
            style = Typography.labelLarge,
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
private fun SignUpButtonPreview() {
    SignupTheme {
        SignUpButton(
            signUpResult = SignUpResult.Failure
        )
    }
}
