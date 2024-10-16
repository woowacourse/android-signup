package nextstep.signup.ui.signup


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.signup.R
import nextstep.signup.ui.common.button.StateButton
import nextstep.signup.ui.common.textfield.InputType
import nextstep.signup.ui.common.textfield.SingleLineTextInput
import nextstep.signup.ui.theme.SignUpTheme
import nextstep.signup.ui.theme.Typography

@Preview(showBackground = true)
@Composable
fun SignUpLayoutPreview() {
    SignUpTheme {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
        ) {
            SignUpInteractionLayer {}
        }
    }
}

@Composable
fun SignUpTitle() {
    Text(
        text = stringResource(id = R.string.signup_title),
        style = Typography.titleLarge,
    )
}

@Composable
fun SignUpTextFields() {
    Column(
        modifier = Modifier
            .heightIn(min = 350.dp, max = 640.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

    }
}

@Composable
fun SignUpInteractionLayer(
    onButtonClicked: () -> Unit,
) {
    val childModifier = Modifier.fillMaxWidth()
    Column(
        modifier = Modifier
            .fillMaxHeight(0.7f)
            .padding(32.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SingleLineTextInput(
            modifier = childModifier,
            label = stringResource(id = R.string.signup_username),
            inputType = InputType.Username,
        )
        SingleLineTextInput(
            modifier = childModifier,
            label = stringResource(id = R.string.signup_email),
            inputType = InputType.Email,
        )
        SingleLineTextInput(
            modifier = childModifier,
            label = stringResource(id = R.string.signup_password),
            inputType = InputType.Password,
        )
        SingleLineTextInput(
            modifier = childModifier,
            label = stringResource(id = R.string.signup_password_confirm),
            inputType = InputType.Password,
        )
        StateButton(text = stringResource(id = R.string.signup_signup)) {
            onButtonClicked()
        }
    }
}

@Composable
fun SignUpLayout(
    onButtonClicked: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxHeight(0.7f),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SignUpTitle()
        SignUpInteractionLayer {
            onButtonClicked()
        }
    }
}
