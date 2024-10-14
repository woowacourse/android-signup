package nextstep.signup.auth.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.R
import nextstep.signup.ui.theme.SignupTheme

@Composable
internal fun SignUpTitle() {
    Text(
        text = stringResource(id = R.string.sign_up_title),
        style = MaterialTheme.typography.titleLarge.copy(
            fontWeight = FontWeight.Bold
        )
    )
}

@Preview
@Composable
private fun SignUpTitlePreview() {
    SignupTheme {
        Surface {
            SignUpTitle()
        }
    }
}
