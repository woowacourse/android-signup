package nextstep.signup.ui.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import nextstep.signup.R
import nextstep.signup.ui.component.SignUpButton
import nextstep.signup.ui.component.SignUpHeaderText
import nextstep.signup.ui.component.SignUpTextFields

@Composable
fun SignUpScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        SignUpHeaderText(
            modifier =
                Modifier.padding(
                    start = 34.dp,
                    end = 34.dp,
                    top = 112.dp,
                    bottom = 42.dp,
                ),
            text = stringResource(R.string.sign_up_greeting),
        )

        SignUpTextFields(
            modifier =
                Modifier.padding(start = 32.dp, end = 32.dp),
        )

        SignUpButton(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .padding(start = 32.dp, end = 32.dp),
            text = stringResource(R.string.sign_up_button_label),
            onclick = {},
        )
    }
}
