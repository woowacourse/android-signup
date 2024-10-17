package nextstep.signup.ui.auth.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import nextstep.signup.ui.auth.component.SignUpFormState

class SignUpPreviewParamsProvider : PreviewParameterProvider<SignUpFormState> {
    override val values: Sequence<SignUpFormState>
        get() = sequenceOf(
            SignUpFormState("", "", "", ""),
            SignUpFormState("userName", "email", "password", "confirmPassword")
        )
}
