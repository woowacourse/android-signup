package nextstep.signup.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import nextstep.signup.domain.SignUp
import nextstep.signup.presentation.components.signup.SignUpForm

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var signUpData by remember { mutableStateOf(SignUp.BLANK_SIGN_UP) }

            SignUpForm(
                signUpData = signUpData,
                onDataChange = { signUpData = it }
            )
        }
    }
}
