package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import nextstep.signup.component.SignUpSubmitButton
import nextstep.signup.component.SignUpTextField
import nextstep.signup.component.SignUpTitle
import nextstep.signup.ui.theme.SignupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SignUpScreen()
                }
            }
        }
    }
}

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier
) {
    val labels = textFieldLabels()

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 32.dp, end = 32.dp, top = 22.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        SignUpTitle(title = stringResource(R.string.sign_up_title))

        for (label in labels) {
            SignUpTextField(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                label = label
            )
        }

        SignUpSubmitButton(
            modifier = modifier
                .fillMaxWidth()
                .padding(vertical = 32.dp),
            text = stringResource(R.string.button_sign_up),
            onClick = { }
        )
    }
}

@Composable
private fun textFieldLabels(): List<String> {
    return listOf(
        stringResource(R.string.input_hint_username),
        stringResource(R.string.input_hint_email),
        stringResource(R.string.input_hint_password),
        stringResource(R.string.input_hint_password_confirm)
    )
}
