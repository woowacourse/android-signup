package nextstep.signup.ui.signupform

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.signup.ui.theme.SignupTheme

@Composable
fun SignUpForm(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Welcome to Compose \uD83D\uDE80",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 42.dp),
        )
        SignUpTextField("UserName", modifier = Modifier.padding(bottom = 36.dp))
        SignUpTextField("Email", modifier = Modifier.padding(bottom = 36.dp))
        SignUpPasswordTextField("Password", modifier = Modifier.padding(bottom = 36.dp))
        SignUpPasswordTextField("Password Confirm", modifier = Modifier.padding(bottom = 42.dp))
        ConfirmButton("Sign Up", modifier = Modifier.fillMaxWidth())
    }
}

@Preview(
    showBackground = true,
)
@Composable
fun SignUpFormPreview() {
    SignupTheme {
        SignUpForm()
    }
}
