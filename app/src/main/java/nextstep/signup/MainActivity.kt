package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.signup.ui.theme.Blue50
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
                    Column(
                        modifier = Modifier.padding(horizontal = 33.0.dp)
                    ) {
                        SignUpTitle("Welcome to Compose \uD83D\uDE80")
                        SignUpField("Username")
                        SignUpField("Email")
                        SignUpField("Password", hidden = true)
                        SignUpField("Password Confirm", hidden = true)
                        SignUpButton("Sign Up")
                    }
                }
            }
        }
    }
}

@Composable
fun SignUpTitle(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        fontSize = 28.sp,
        fontWeight = FontWeight.W700,
        modifier = modifier
            .wrapContentWidth()
            .padding(top = 33.0.dp, bottom = 42.0.dp)
    )
}

@Composable
fun SignUpField(label: String, modifier: Modifier = Modifier, hidden: Boolean = false) {
    var textValue by remember { mutableStateOf(TextFieldValue("")) }

    TextField(
        value = textValue,
        onValueChange = { textValue = it },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Blue50,
            focusedLabelColor = Blue50
        ),
        maxLines = 1,
        label = { Text(text = label) },
        visualTransformation = if (!hidden) VisualTransformation.None
        else PasswordVisualTransformation(),
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 36.dp)
    )
}

@Composable
fun SignUpButton(text: String, modifier: Modifier = Modifier) {
    Button(
        onClick = {

        },
        colors = ButtonColors(
            containerColor = Blue50,
            contentColor = Color.White,
            disabledContainerColor = Color.Gray,
            disabledContentColor = Color.White
        ),
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(text = text, fontSize = 14.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SignupTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 33.0.dp)
            ) {
                SignUpTitle("Welcome to Compose \uD83D\uDE80")
                SignUpField("Username")
                SignUpField("Email")
                SignUpField("Password", hidden = true)
                SignUpField("Password Confirm", hidden = true)
                SignUpButton("Sign Up")
            }
        }
    }
}
