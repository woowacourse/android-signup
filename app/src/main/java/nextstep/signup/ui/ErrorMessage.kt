import androidx.annotation.StringRes
import nextstep.signup.R
import nextstep.signup.model.InputError

@StringRes
fun InputError.getErrorMessageResId(): Int? {
    return when (this) {
        InputError.NameError.InvalidLength -> R.string.error_user_name_length
        InputError.NameError.InvalidFormat -> R.string.error_user_name_format

        InputError.EmailError.InvalidFormat -> R.string.error_user_email_format
        InputError.PasswordError.InvalidLength -> R.string.error_user_password_length
        InputError.PasswordError.InvalidFormat -> R.string.error_user_password_format
        InputError.PasswordConfirmError.PasswordMismatch -> R.string.error_user_password_confirm
        InputError.None -> null
    }
}
