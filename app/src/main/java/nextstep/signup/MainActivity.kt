package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
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
import androidx.compose.ui.res.stringResource
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
                    color = MaterialTheme.colorScheme.background,
                ) {
                    SignUpScreen()
                }
            }
        }
    }

    @Composable
    private fun SignUpScreen() {
        var userName by remember { mutableStateOf(TextFieldValue("")) }
        var email by remember { mutableStateOf(TextFieldValue("")) }
        var password by remember { mutableStateOf(TextFieldValue("")) }
        var confirmedPassword by remember { mutableStateOf(TextFieldValue("")) }

        Column(
            modifier = Modifier.padding(horizontal = 33.0.dp),
        ) {
            SignUpTitle(R.string.signup_title)
            SignUpField(
                R.string.signup_username_label,
                textValue = userName,
                onValueChange = { userName = it },
                validateField = { SignupFieldValidation.isValidUserName(it) },
            )
            SignUpField(
                R.string.signup_email_label,
                textValue = email,
                onValueChange = { email = it },
                validateField = { SignupFieldValidation.isValidEmail(it) },
            )

            SignUpField(
                R.string.signup_password_label,
                textValue = password,
                onValueChange = { password = it },
                validateField = { SignupFieldValidation.isValidPassword(it) },
                hidden = true,
            )

            SignUpField(
                R.string.signup_password_confirm_label,
                textValue = confirmedPassword,
                onValueChange = { confirmedPassword = it },
                validateField = {
                    SignupFieldValidation.isValidConfirmedPassword(
                        password.text,
                        it,
                    )
                },
                hidden = true,
            )
            SignUpButton(R.string.signup_button)
        }
    }

    @Composable
    fun SignUpTitle(
        @StringRes titleId: Int,
        modifier: Modifier = Modifier,
    ) {
        Text(
            text = stringResource(titleId),
            fontSize = 28.sp,
            fontWeight = FontWeight.W700,
            modifier =
                modifier
                    .wrapContentWidth()
                    .padding(top = 33.0.dp, bottom = 42.0.dp),
        )
    }

    @Composable
    fun SignUpField(
        @StringRes labelId: Int,
        textValue: TextFieldValue,
        onValueChange: (TextFieldValue) -> Unit,
        modifier: Modifier = Modifier,
        validateField: ((String) -> ValidationResult)? = null,
        hidden: Boolean = false,
    ) {
        val validationResult =
            validateField?.invoke(textValue.text) ?: ValidationResult(isValid = true)
        val textColor = if (validationResult.isValid) Blue50 else Color.Red

        TextField(
            value = textValue,
            onValueChange = { onValueChange(it) },
            supportingText = {
                Text(
                    text = validationResult.errorMessage,
                    color = textColor,
                )
            },
            colors =
                TextFieldDefaults.colors(
                    focusedIndicatorColor = textColor,
                    focusedLabelColor = textColor,
                ),
            maxLines = 1,
            label = { Text(text = stringResource(labelId)) },
            visualTransformation =
                if (!hidden) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
            modifier =
                modifier
                    .fillMaxWidth()
                    .padding(bottom = 36.dp),
        )
    }

    @Composable
    fun SignUpButton(
        @StringRes textId: Int,
        modifier: Modifier = Modifier,
    ) {
        Button(
            onClick = {
            },
            colors =
                ButtonColors(
                    containerColor = Blue50,
                    contentColor = Color.White,
                    disabledContainerColor = Color.Gray,
                    disabledContentColor = Color.White,
                ),
            modifier =
                modifier
                    .fillMaxWidth()
                    .height(50.dp),
        ) {
            Text(text = stringResource(textId), fontSize = 14.sp)
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
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
