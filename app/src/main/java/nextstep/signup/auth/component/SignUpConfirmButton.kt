package nextstep.signup.auth.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.ui.theme.SignupTheme

@Composable
internal fun SignUpConfirmButton(
    onClickSignUp: () -> Unit,
    enableSignUp: Boolean
) {
    Button(
        modifier = Modifier
            .fillMaxWidth(),
        onClick = { onClickSignUp() }, enabled = enableSignUp
    ) {
        Text(
            modifier = Modifier.padding(vertical = 6.dp),
            text = "Sign Up",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview(name = "enabled")
@Composable
private fun PreviewSignUpConfirmButton() {
    SignupTheme {
        Surface {
            SignUpConfirmButton({}, true)
        }
    }
}

@Preview(name = "disabled")
@Composable
private fun PreviewSignUpConfirmButton2() {
    SignupTheme {
        Surface {
            SignUpConfirmButton({}, false)
        }
    }
}