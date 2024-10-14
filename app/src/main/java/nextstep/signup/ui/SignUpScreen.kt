package nextstep.signup.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.R
import nextstep.signup.component.TitleText
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun SignUpScreen() {
    Column {
        Spacer(modifier = Modifier.height(60.dp))
        TitleText(
            modifier = Modifier.fillMaxWidth(),
            titleResId = R.string.sign_up_title
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignupTheme {
        SignUpScreen()
    }
}
