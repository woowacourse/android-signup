# android-signup# android-signup

# step1

- [x] 학습 테스트 완성

# step2

- [x] 디자인 시안을 참고하여 회원가입 뷰를 구현한다.

- [x] ViewModel, Hilt 등은 회원가입 미션에서 활용하지 않는다. 컴포즈 학습에 집중하자.
- [x] 사용자 입력 및 유효성 검사에 대해서는 이 단계에서 고민하지 않아도 된다.
- [x] 컴포저블 함수가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.
- [x] Material3 Button, TextField를 활용한다.

## step2 피드백

- [x] TextField 의 배경색을 피그마 시안에 맞도록

### step3

- [x] 디자인 시안을 참고하여 회원가입 뷰에 유효성 검사 로직을 추가한다.
- [x] 유효성 검사 로직에 대한 테스트 코드를 추가한다.
    - [x] 이름은 2~5자여야 합니다.
    - [x] 이름에는 숫자나 기호가 포함될 수 없습니다.
    - [x] 이메일 형식이 올바르지 않습니다.
    - [x] 비밀번호는 8~16자여야 합니다.
    - [x] 비밀번호는 영문과 숫자를 포함해야 합니다.
    - [x] 비밀번호가 일치하지 않습니다.

### step4

- [x] 디자인 시안을 참고하여 모든 필드가 에러 없이 채워진 경우에만 Sign up 버튼을 활성화한다.
- [x] 유효성 검사 로직과 뷰 로직을 나누어 관심사를 분리한다.
- [ ] 모든 로직에 테스트 코드를 추가한다. todo: SignUpScreen
- [x] 테스트 가능한 부분과 테스트하기 힘든 부분을 분리해 테스트 가능한 부분에 대해서만 테스트를 진행한다.
- [ ] (선택사항) Sign up 버튼을 클릭하면 회원가입 완료 스낵바가 노출된다.

### step4 이후 추가로 할 것들

- [x] recomposition study 테스트
- [x] SignupScreen 테스트가 가능한가?
- [x] recomposition 프로덕션에 적용
- [ ] rememberSavable 추가하기
- [ ] [TextField 의 focus 를 빼내는 법?](https://velog.io/@heeung/Android-Compose-Textfield-%ED%8F%AC%EC%BB%A4%EC%8A%A4%EB%A5%BC-%EC%B2%98%EB%A6%AC%ED%95%B4%EB%B3%B4%EC%9E%90) 
