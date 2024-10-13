package nextstep.signup.model

import androidx.annotation.StringRes

data class InputValidation(
    @StringRes val stringRes: Int? = null,
    val isError: Boolean,
)
