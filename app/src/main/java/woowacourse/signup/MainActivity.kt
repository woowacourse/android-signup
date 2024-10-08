package woowacourse.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import woowacourse.signup.ui.theme.Blue50
import woowacourse.signup.ui.util.FillMaxTheme
import woowacourse.signup.ui.util.Space

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FillMaxTheme {
                SignUpLayout()
            }
        }
    }
}

@Composable
private fun SignUpLayout() {
    Column {
        SignUpTitle()
        Space(dp = 18)
        SignUpInput(titleId = R.string.username_input)
        SignUpInput(titleId = R.string.email_input)
        SignUpInput(titleId = R.string.password_input, isPassword = true)
        SignUpInput(titleId = R.string.password_confirm_input, isPassword = true)
        Space(dp = 24)
        SignUpButton()
    }
}

@Composable
private fun SignUpTitle() {
    Text(
        text = stringResource(id = R.string.sign_up_title),
        fontSize = 26.sp,
        color = Color.Black,
        fontWeight = FontWeight.W700,
        textAlign = TextAlign.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 60.dp)
    )
}

@Composable
private fun SignUpInput(
    @StringRes titleId: Int,
    isPassword: Boolean = false,
) {
    var input by remember { mutableStateOf("") }

    TextField(
        label = { SignUpInputLabel(titleId) },
        value = input,
        onValueChange = { input = it },
        textStyle = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight.W400,
        ),
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Blue50,
            focusedLabelColor = Blue50,
            cursorColor = Blue50,
        ),
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 18.dp),
    )
}

@Composable
private fun SignUpInputLabel(@StringRes labelId: Int) {
    Text(
        text = stringResource(id = labelId),
        fontWeight = FontWeight.W400,
    )
}

@Composable
fun SignUpButton() {
    Button(
        onClick = {
            // TODO
        },
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Blue50,
        ),
        modifier =
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp),
    ) {
        Text(
            text = "Sign Up",
            fontSize = 14.sp,
            fontWeight = FontWeight.W500,
            modifier = Modifier.padding(vertical = 15.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MainActivityPreview() {
    FillMaxTheme {
        SignUpLayout()
    }
}
