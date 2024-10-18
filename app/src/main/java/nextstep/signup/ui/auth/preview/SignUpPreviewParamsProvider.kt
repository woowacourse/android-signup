package nextstep.signup.ui.auth.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import nextstep.signup.ui.auth.model.SignUpFormState

class SignUpPreviewParamsProvider : PreviewParameterProvider<SignUpFormState> {
    override val values: Sequence<SignUpFormState>
        get() = sequenceOf(
            SignUpFormState("", "", "", ""),
            SignUpFormState("userName", "email", "password", "confirmPassword")
        )
}
