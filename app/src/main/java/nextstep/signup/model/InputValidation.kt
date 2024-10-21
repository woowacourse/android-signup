package nextstep.signup.model

import androidx.annotation.StringRes

data class InputValidation(
    @StringRes val errorMessageRes: Int? = null,
    val isError: Boolean,
)
