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
                    Column(
                        modifier = Modifier.padding(horizontal = 33.0.dp),
                    ) {
                        SignUpTitle(R.string.signup_title)
                        SignUpField(R.string.signup_username_label)
                        SignUpField(R.string.signup_email_label)
                        SignUpField(R.string.signup_password_label, hidden = true)
                        SignUpField(R.string.signup_password_confirm_label, hidden = true)
                        SignUpButton(R.string.signup_button)
                    }
                }
            }
        }
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
    modifier: Modifier = Modifier,
    hidden: Boolean = false,
) {
    var textValue by remember { mutableStateOf(TextFieldValue("")) }
    val label = stringResource(labelId)

    TextField(
        value = textValue,
        onValueChange = {
            textValue = it
        },
        supportingText = { Text(text = "") },
        colors =
        TextFieldDefaults.colors(
            focusedIndicatorColor = Blue50,
            focusedLabelColor = Blue50,
        ),
        maxLines = 1,
        label = { Text(text = label) },
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
            Column(
                modifier = Modifier.padding(horizontal = 33.0.dp),
            ) {
                SignUpTitle(R.string.signup_title)
                SignUpField(R.string.signup_username_label)
                SignUpField(R.string.signup_email_label)
                SignUpField(R.string.signup_password_label, hidden = true)
                SignUpField(R.string.signup_password_confirm_label, hidden = true)
                SignUpButton(R.string.signup_button)
            }
        }
    }
}
