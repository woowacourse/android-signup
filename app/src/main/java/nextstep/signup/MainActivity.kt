package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.signup.ui.theme.SignupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupTheme(dynamicColor = false) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SignUpComponent()
                }
            }
        }
    }
}

@Composable
fun SignUpComponent() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Greeting("Welcome to Compose 🚀")
        InputText("Username")
        InputText("Email", KeyboardType.Email)
        InputText("Password", KeyboardType.Password, PasswordVisualTransformation())
        InputText("Password Confirm", KeyboardType.Password, PasswordVisualTransformation())
        SubmitButton("Sign Up")
    }
}

@Composable
fun Greeting(title: String) {
    Text(
        text = title,
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp
        ),
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(0.dp, 42.dp)
    )
}

@Composable
fun InputText(
    title: String,
    keyBoardType: KeyboardType = KeyboardType.Text,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    var contents: String by remember { mutableStateOf("") }
    TextField(
        contents,
        label = { Text(text = title) },
        placeholder = { Text(text = title) },
        onValueChange = { contents = it },
        keyboardOptions = KeyboardOptions(keyboardType = keyBoardType),
        visualTransformation = visualTransformation
    )
    Spacer(Modifier.height(36.dp))
}

@Composable
fun SubmitButton(titleText: String) {
    Button(onClick = {}, contentPadding = PaddingValues(120.dp, 15.dp)) {
        Text(text = titleText)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpPreview() {
    SignupTheme {
        SignUpComponent()
    }
}
