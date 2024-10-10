package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import nextstep.signup.ui.theme.SignupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SignupTheme {
        Greeting("Android")
    }
}

@Composable
fun SignUpTitle(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier,
        style = TextStyle(
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )
    )
}

@Preview(showBackground = true)
@Composable
fun SignUpTitlePreview() {
    SignupTheme {
        SignUpTitle(stringResource(R.string.sign_up_title))
    }
}
@Composable
fun SingUpTextField(label: String = "Username") {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { text = it },
        label = { Text(label) }
    )
}

@Preview(showBackground = true)
@Composable
fun SingUpTextFieldPreview() {
    SignupTheme {
        SingUpTextField()
    }
}

@Composable
fun SignUpSubmitButton(modifier: Modifier, text: String, onClick: () -> Unit) {
    Button(
        modifier = modifier,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)

    ) {
        Text(text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpSubmitButtonPreview() {
    SignupTheme {
        SignUpSubmitButton(modifier = Modifier, text = "Sign Up", onClick = { })
    }
}
