package nextstep.signup.ui.signup

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.R
import nextstep.signup.ui.theme.SignUpTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignUpTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
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
    SignUpTheme(
        darkTheme = true,
    ) {
        Surface(
            modifier =
                Modifier
                    .fillMaxSize()
                    .padding(32.dp),
        ) {
            SignUpLayout(
                onButtonClicked = { },
            )
        }
    }
}
