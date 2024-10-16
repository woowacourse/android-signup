package nextstep.signup.ui.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SignUpInformation(
    val userName: UserName = UserName(),
    val email: Email = Email(),
    val password: Password = Password(),
) : Parcelable
