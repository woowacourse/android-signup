package nextstep.signup

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.ui.component.ButtonComponent

@Composable
fun SignUpButtonComposable(isEnabled: Boolean) {
    ButtonComponent(enabled = isEnabled, description = stringResource(id = R.string.main_sign_up))
}

@Preview(showBackground = true)
@Composable
private fun SignUpButtonComposablePreview() {
    SignUpButtonComposable(isEnabled = true)
}
