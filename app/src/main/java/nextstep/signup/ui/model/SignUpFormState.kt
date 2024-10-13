package nextstep.signup.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SignUpFormState(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val passwordConfirmation: String = "",
) : Parcelable
