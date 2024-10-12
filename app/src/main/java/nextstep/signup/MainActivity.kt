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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.signup.ui.theme.SignupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupTheme {
                SignUpScreen()
            }
        }
    }
}

@Composable
fun SignUpScreen() {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = 32.dp,
                top = 50.dp,
                end = 32.dp
            ),
        color = MaterialTheme.colorScheme.background
    ) {
        var username by rememberSaveable { mutableStateOf("") }
        var email by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }
        var passwordConfirm by rememberSaveable { mutableStateOf("") }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(36.dp)
        ) {
            HeadLine(stringResource(R.string.sign_up_headline))
            SignUpTextField(
                value = username,
                onValueChange = { username = it },
                label = stringResource(R.string.sign_up_username_label)
            )
            SignUpTextField(
                value = email,
                onValueChange = { email = it },
                label = stringResource(R.string.sign_up_email_label),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            SignUpTextField(
                value = password,
                onValueChange = { password = it },
                label = stringResource(R.string.sign_up_password_label),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation()
            )
            SignUpTextField(
                value = passwordConfirm,
                onValueChange = { passwordConfirm = it },
                label = stringResource(R.string.sign_up_password_confirm_label),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = PasswordVisualTransformation()
            )
            Spacer(modifier = Modifier.height(6.dp))
            SignUpButton()
        }
    }
}

@Composable
fun HeadLine(text: String) {
    Text(
        text = text,
        color = Color.Black,
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun SignUpTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    keyboardOptions: KeyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
    singleLine: Boolean = true,
    focusedLabelColor: Color = colorResource(id = R.color.blue50),
    focusedIndicatorColor: Color = colorResource(id = R.color.blue50),
    cursorColor: Color = colorResource(id = R.color.blue50),
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        singleLine = singleLine,
        keyboardOptions = keyboardOptions,
        colors = TextFieldDefaults.colors(
            focusedLabelColor = focusedLabelColor,
            focusedIndicatorColor = focusedIndicatorColor,
            cursorColor = cursorColor
        ),
        visualTransformation = visualTransformation
    )
}

@Composable
fun SignUpButton() {
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .clip(RoundedCornerShape(20.dp)),
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.blue50))
    ) {
        Text(text = stringResource(id = R.string.sign_up_sign_up_label))
    }
}
