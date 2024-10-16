package nextstep.signup.ui.model

sealed class Information(
    open val value: String,
) {
    abstract fun isValid(): Boolean

    abstract fun errorMessage(): String
}
