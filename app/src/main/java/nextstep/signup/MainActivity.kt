package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import nextstep.signup.domain.SignUpForm.Companion.emptySignUpForm
import nextstep.signup.ui.SignUpScreen
import nextstep.signup.ui.theme.SignupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var signUpForm by rememberSaveable { mutableStateOf(emptySignUpForm) }

            SignupTheme {
                SignUpScreen(
                    signUpForm,
                ) { newSignUpForm ->
                    signUpForm = newSignUpForm
                }
            }
        }
    }
}
