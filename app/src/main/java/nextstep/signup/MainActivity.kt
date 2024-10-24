package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import nextstep.signup.model.validation.CompositeValidation
import nextstep.signup.model.validation.EqualValidation
import nextstep.signup.model.validation.LengthValidation
import nextstep.signup.model.validation.RegexValidation
import nextstep.signup.ui.signup.SignUpScreen
import nextstep.signup.ui.theme.SignupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val userNameLengthValidation = LengthValidation(USER_NAME_LENGTH_RANGE)
        val characterValidation = RegexValidation(USER_NAME_REGEX)
        val userNameValidation = CompositeValidation(userNameLengthValidation, characterValidation)

        val emailValidation = RegexValidation(EMAIL_REGEX)

        val passwordLengthValidation = LengthValidation(PASSWORD_LENGTH_RANGE)
        val regexValidation = RegexValidation(PASSWORD_REGEX)
        val passwordValidation = CompositeValidation(passwordLengthValidation, regexValidation)
        setContent {
            SignupTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    SignUpScreen(
                        userNameValidation = userNameValidation,
                        emailValidation = emailValidation,
                        passwordValidation = passwordValidation,
                        modifier =
                        Modifier.padding(
                            top = 60.dp,
                            start = 32.dp,
                            end = 32.dp,
                        ),
                    )
                }
            }
        }
    }

    companion object {
        private val USER_NAME_LENGTH_RANGE = 2..5
        private val USER_NAME_REGEX = "[a-zA-Z가-힣]+".toRegex()
        private val EMAIL_REGEX = "[a-zA-Z0-9._-]+@[a-zA-Z]+\\.+[a-zA-Z]+".toRegex()
        private val PASSWORD_LENGTH_RANGE = 8..16
        private val PASSWORD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).+\$".toRegex()
    }
}
