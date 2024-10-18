package nextstep.signup.ui.auth.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import nextstep.signup.ui.auth.model.SignUpFormState

class SignUpPreviewParamsProvider : PreviewParameterProvider<SignUpFormState> {
    override val values: Sequence<SignUpFormState>
        get() = sequenceOf(
            SignUpFormState("", "", "", ""),
            SignUpFormState("user", "1", "2", "3"),
            SignUpFormState("user", "sample@naver.com", "a", "3"),
            SignUpFormState("user", "sample@naver.com", "abcd1234", "1"),
            SignUpFormState("user", "sample@naver.com", "abcd1234", "abcd1234"),
        )
}
