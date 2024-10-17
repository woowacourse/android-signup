package nextstep.signup.ui

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.launch
import nextstep.signup.R
import nextstep.signup.ui.component.SubmitButton

@Composable
fun SignUpButton(
    enable: Boolean,
    onClick: () -> Unit = {}
) {
    val snackbarHostState = remember {
        SnackbarHostState()
    }

    val coroutineScope = rememberCoroutineScope()

    val context = LocalContext.current

    SubmitButton(
        text = stringResource(R.string.sign_up_submit_btn),
        enabled = enable,
        onClick = {
            onClick()
            coroutineScope.launch {
                snackbarHostState.showSnackbar(
                    message = context.getString(R.string.sign_up_complete),
                    duration = SnackbarDuration.Short
                )
            }
        },
    )
    SnackbarHost(hostState = snackbarHostState)
}