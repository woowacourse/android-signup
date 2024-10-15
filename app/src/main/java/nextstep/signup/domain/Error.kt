package nextstep.signup.domain

enum class Error(val code : Int, val message : String) {
    INVALID_USERNAME_LENGTH(100, "이름은 2자 이상 5자 이하이여야 합니다."),
    INVALID_USERNAME_TYPE(101, "이름에는 숫자나 기호가 포함될 수 없습니다."),
    INVALID_EMAIL(200, "이메일 형식이 올바르지 않습니다."),
    INVALID_PASSWORD_LENGTH(300, "비밀번호는 8자 이상 16자 이하이어야 합니다."),
    INVALID_PASSWORD_TYPE(301, "비밀번호는 영문과 숫자를 포함해야 합니다."),
    INVALID_CONFIRM_PASSWORD(400, "비밀번호가 일치하지 않습니다.")
}
