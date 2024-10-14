package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import nextstep.signup.ui.theme.SignupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    SignUpScreen()
                }
            }
        }
    }
}

@Composable
fun SignUpScreen() {
    Column(
        modifier =
        Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        var userName by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        var confirmPassword by remember { mutableStateOf("") }
        TitleText(stringResource(R.string.title))

        Spacer(modifier = Modifier.height(16.dp))

        InputField(
            label = stringResource(R.string.sign_up),
            value = userName,
            onValueChange = { userName = it },
            isPasswordInputField = false,
            keyboardType = KeyboardType.Text,
            paddingBottom = 36.dp,
        )

        InputField(
            label = stringResource(R.string.email),
            value = email,
            onValueChange = { email = it },
            isPasswordInputField = false,
            keyboardType = KeyboardType.Email,
            paddingBottom = 36.dp,
        )


        InputField(
            label = stringResource(R.string.password),
            value = password,
            onValueChange = { password = it },
            isPasswordInputField = true,
            keyboardType = KeyboardType.Password,
            paddingBottom = 36.dp,
        )

        InputField(
            label = stringResource(R.string.password_confirm),
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            isPasswordInputField = true,
            keyboardType = KeyboardType.Password,
            paddingBottom = 36.dp,
        )

        SignUpButton(stringResource(R.string.sign_up))
    }
}

@Composable
fun TitleText(text: String) {
    Text(
        text = text,
        style =
        MaterialTheme.typography.titleLarge.copy(
            fontWeight = FontWeight.Bold,
        ),
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
    )
}

@Composable
fun InputField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    isPasswordInputField: Boolean,
    keyboardType: KeyboardType = KeyboardType.Text,
    paddingBottom: Dp = 0.dp,
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(bottom = paddingBottom),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
        ),
        visualTransformation = visualTransformation(isPasswordInputField)
    )
}

@Composable
private fun visualTransformation(isPasswordInputField: Boolean): VisualTransformation {
    return if (isPasswordInputField) PasswordVisualTransformation()
    else VisualTransformation.None
}

@Composable
fun SignUpButton(
    buttonText: String,
) {
    Button(
        onClick = {},
        modifier =
        Modifier
            .fillMaxWidth()
            .height(60.dp),
        colors =
        ButtonDefaults.buttonColors(
            containerColor = colorResource(R.color.blue_50),
            contentColor = Color.White,
        ),
    ) {
        Text(text = buttonText)
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpScreenPreview() {
    SignUpScreen()
}
