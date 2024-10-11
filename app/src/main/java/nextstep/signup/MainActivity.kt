package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.ui.ButtonView
import nextstep.signup.ui.TextFieldView
import nextstep.signup.ui.TextView
import nextstep.signup.ui.theme.SignupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SignupTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 56.dp, start = 32.dp, end = 32.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        TextView(text = "Welcome to Compose 🚀")
                        TextFieldScreen()
                        ButtonView(description = "Sign Up", paddingTop = 42.dp)
                    }
                }
            }
        }
    }
}

@Composable
fun TextFieldScreen() {
    TextFieldView(paddingTop = 42.dp, label = "UserName")
    TextFieldView(paddingTop = 36.dp, label = "Email")
    TextFieldView(paddingTop = 36.dp, label = "Password")
    TextFieldView(paddingTop = 36.dp, label = "Password Confirm")
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SignupTheme {
        TextFieldScreen()
    }
}
