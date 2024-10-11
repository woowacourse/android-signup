package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.signup.ui.theme.SignupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            start = 32.dp,
                            top = 50.dp,
                            end = 32.dp,
                        ),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    var username by rememberSaveable { mutableStateOf("") }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        HeadLine(getString(R.string.sign_up_headline))
                        Spacer(modifier = Modifier.height(36.dp))
                        SignUpTextField(
                            value = username,
                            onValueChange = { username = it },
                            label = getString(R.string.sign_up_username_label),
                        )
                    }

                }
            }
        }
    }
}

@Composable
fun HeadLine(text: String) {
    Text(
        text = text,
        color = Color.Black,
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold,
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
    cursorColor: Color = colorResource(id = R.color.blue50)
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
        )
    )
}
