package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import nextstep.signup.ui.SignUpButton
import nextstep.signup.ui.SignUpTextField
import nextstep.signup.ui.SignupTitle
import nextstep.signup.ui.theme.SignupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 32.dp),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top,
                    ) {
                        SignupTitle(Modifier.padding(top = 60.dp))
                        SignUpTextField(
                            Modifier.padding(top = 36.dp),
                            getString(R.string.user_name),
                        )
                        SignUpTextField(
                            Modifier.padding(top = 36.dp),
                            getString(R.string.email),
                        )
                        SignUpTextField(
                            Modifier.padding(top = 36.dp),
                            getString(R.string.password),
                        )
                        SignUpTextField(
                            Modifier.padding(top = 36.dp),
                            getString(R.string.password_confirm),
                        )
                        SignUpButton(
                            Modifier
                                .padding(top = 42.dp),
                            getString(R.string.sign_up),
                        )
                    }
                }
            }
        }
    }
}
