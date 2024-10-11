package nextstep.signup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.signup.ui.theme.Blue50
import nextstep.signup.ui.theme.BlueGray20
import nextstep.signup.ui.theme.Gray50
import nextstep.signup.ui.theme.SignupTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SignupTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    SignUp()
                }
            }
        }
    }
}

@Composable
fun SignUp() {
    val name = remember {
        mutableStateOf("")
    }

    val email = remember {
        mutableStateOf("")
    }

    val password = remember {
        mutableStateOf("")
    }

    val passwordCheck = remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.padding(horizontal = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(Modifier.height(60.dp))

        Text(
            text = "Welcome to Compose \uD83D\uDE80",
            fontSize = 26.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
        )

        Spacer(Modifier.height(42.dp))

        TextField(
            value = name.value,
            onValueChange = {
                name.value = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(53.dp),
            colors = TextFieldDefaults.colors(
                focusedLabelColor = Blue50,
                unfocusedLabelColor = Gray50,
                unfocusedContainerColor = BlueGray20,
                focusedContainerColor = BlueGray20,
                focusedIndicatorColor = Blue50,
                unfocusedIndicatorColor = Gray50,
            ),
            placeholder = {
                Text("Username")
            },
            label = {
                Text("Username")
            },
            textStyle = TextStyle(
                color = Gray50,
                fontSize = 16.sp,
            )

        )

        Spacer(Modifier.height(42.dp))
        TextField(
            value = email.value,
            onValueChange = {
                email.value = it
            },
            placeholder = {
                Text("Email")
            },
            label = {
                Text("Username")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(53.dp),
            colors = TextFieldDefaults.colors(
                focusedLabelColor = Blue50,
                unfocusedLabelColor = Gray50,
                unfocusedContainerColor = BlueGray20,
                focusedContainerColor = BlueGray20,
                focusedIndicatorColor = Blue50,
                unfocusedIndicatorColor = Gray50,
            ),

            textStyle = TextStyle(
                color = Gray50,
                fontSize = 16.sp,
            )

        )
        Spacer(Modifier.height(42.dp))

        TextField(
            value = password.value,
            onValueChange = {
                password.value = it
            },
            placeholder = {
                Text("Password")
            },
            label = {
                Text("Password")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(53.dp),
            colors = TextFieldDefaults.colors(
                focusedLabelColor = Blue50,
                unfocusedLabelColor = Gray50,
                unfocusedContainerColor = BlueGray20,
                focusedContainerColor = BlueGray20,
                focusedIndicatorColor = Blue50,
                unfocusedIndicatorColor = Gray50,
            ),

            textStyle = TextStyle(
                color = Gray50,
                fontSize = 16.sp,
            )

        )
        Spacer(Modifier.height(42.dp))

        TextField(
            value = passwordCheck.value,
            onValueChange = {
                passwordCheck.value = it
            },
            placeholder = {
                Text("PasswordCheck")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(53.dp),
            colors = TextFieldDefaults.colors(
                focusedLabelColor = Blue50,
                unfocusedLabelColor = Gray50,
                unfocusedContainerColor = BlueGray20,
                focusedContainerColor = BlueGray20,
                focusedIndicatorColor = Blue50,
                unfocusedIndicatorColor = Gray50,
            ),
            label = {
                Text("PasswordCheck")
            },
            textStyle = TextStyle(
                color = Gray50,
                fontSize = 16.sp,
            )

        )
        Spacer(Modifier.height(42.dp))

        Button(
            content = {
                Text("Sign Up")
            },
            onClick = {},
            contentPadding = PaddingValues(15.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonColors(
                containerColor = Blue50,
                contentColor = Color.White,
                disabledContentColor = Blue50,
                disabledContainerColor = Color.White
            )
        )
    }
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFFFFFFFF,
)
@Composable
fun TestPreview() {
    SignupTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            SignUp()
        }
    }

}
