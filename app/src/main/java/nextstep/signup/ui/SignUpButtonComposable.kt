package nextstep.signup.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import nextstep.signup.R
import nextstep.signup.ui.component.ButtonComponent

@Composable
fun SignUpButtonComposable(isEnabled: Boolean) {
    ButtonComponent(enabled = isEnabled, description = stringResource(id = R.string.main_sign_up))
}

class SignUpButtonParameterProvider : PreviewParameterProvider<Boolean> {
    override val values =
        sequenceOf(
            false,
            true,
        )
}

@Preview(showBackground = true)
@Composable
private fun SignUpButtonComposablePreview(
    @PreviewParameter(SignUpButtonParameterProvider::class)
    isEnabled: Boolean,
) {
    SignUpButtonComposable(isEnabled = isEnabled)
}
