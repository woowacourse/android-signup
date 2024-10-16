package nextstep.signup.ui.model

sealed class Information(
    open val text: String,
) {
    abstract fun isValid(): Boolean

    abstract fun errorMessage(): String
}
