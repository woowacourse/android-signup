package nextstep.signup.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import nextstep.signup.ui.theme.SignupTheme

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupTheme {
                SignUpScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SignUpPreview() {
    SignUpScreen()
}
