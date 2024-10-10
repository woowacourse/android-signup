package nextstep.signup.ui.signup

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.R
import nextstep.signup.ui.common.button.StateButton
import nextstep.signup.ui.common.textfield.InputType
import nextstep.signup.ui.common.textfield.OneLineTextInput
import nextstep.signup.ui.signup.composable.layout.SignUpLayout
import nextstep.signup.ui.signup.composable.text.SignUpTitle
import nextstep.signup.ui.theme.SignupTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SignUpLayout(
                        onButtonClicked = { onSignUpClicked() },
                    )
                }
            }
        }
    }

    private fun onSignUpClicked() {
        Toast.makeText(this, getString(R.string.all_not_implemented_yet), Toast.LENGTH_LONG).show()
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    SignupTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            SignUpLayout(
                onButtonClicked = { },
            )
        }
    }
}
