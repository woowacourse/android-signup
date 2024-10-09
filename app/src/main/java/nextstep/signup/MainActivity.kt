package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
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
import androidx.compose.ui.res.stringResource
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
        Greeting(R.string.sign_up_title)
        InputText(R.string.sign_up_user_name_title)
        InputText(R.string.sign_up_email_title, KeyboardType.Email)
        InputText(
            R.string.sign_up_password_title,
            KeyboardType.Password,
            PasswordVisualTransformation()
        )
        InputText(
            R.string.sign_up_password_confirm_title,
            KeyboardType.Password,
            PasswordVisualTransformation()
        )
        SubmitButton(R.string.sign_up_button_title)
    }
}

@Composable
fun Greeting(@StringRes stringRes: Int) {
    Text(
        text = stringResource(stringRes),
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
    @StringRes stringRes: Int,
    keyBoardType: KeyboardType = KeyboardType.Text,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    val title = stringResource(stringRes)
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
fun SubmitButton(@StringRes stringRes: Int) {
    Button(onClick = {}, contentPadding = PaddingValues(120.dp, 15.dp)) {
        Text(text = stringResource(stringRes))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpPreview() {
    SignupTheme {
        SignUpComponent()
    }
}
