# 1단계

## 기능 요구 사항
- 아래 제시된 학습 테스트를 완성한다.

### 컴포즈에서의 학습 테스트
컴포즈의 다양한 컴포넌트를 사용해보면서 각 컴포넌트가 어떻게 작동하는지 알고 싶어질 때가 있다.   
아래와 같이 학습 테스트를 작성하면서 컴포넌트의 속성들을 조작해보자.  
학습 테스트를 작성하며 각 컴포넌트의 속성을 어떻게 설정하면 원하는 동작을 얻을 수 있을지 이해도를 높일 수 있다.

```kotlin
// 1. 모든 테스트가 성공하도록 만들어보자
// 2. 힌트를 참고하여 Preview를 노출시킨다.
// 3. Preview의 interactive 모드를 활용하여 버튼을 클릭해본다.

class LayoutBasicsTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun text() {
        // given
        val text = "안녕 난 컴포즈야~"
        composeTestRule.setContent {
            Text(
                // 바꿔 보세요!
                text = "텍스트",
                color = Color.Blue,
                style = TextStyle(
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.SansSerif
                ),
            )
        }

        // then
        composeTestRule
            .onNodeWithText(text)
            .assertExists()
    }

    @Test
    fun column() {
        // given
        composeTestRule.setContent {
            Column(
                modifier = Modifier.testTag("이름")
            ) {
                // 바꿔 보세요!
                Text(text = "킴포즈", color = Color.Cyan)
                Text(text = "끔포즈", color = Color.Yellow)
            }
        }

        // then
        composeTestRule.onNodeWithTag("이름")
            .onChildren()
            .assertCountEquals(3)
            .onFirst()
            .assert(hasText("깜포즈"))
    }

    @Test
    fun button() {
        // given
        composeTestRule.setContent {
            val enabled = remember { mutableStateOf(true) }
            Button(
                onClick = {
                    // 바꿔 보세요!
                },
                enabled = enabled.value,
                modifier = Modifier.testTag("버튼")
            ) {
                Text(text = "클릭해주세요")
            }
        }

        // when
        val button = composeTestRule
            .onNodeWithTag("버튼")
            .performClick()

        // then
        button.assertIsNotEnabled()
    }
}
```

### 학습 테스트란?
기능 구현을 위한 테스트라기 보다 새로운 API, 라이브러리, 프레임워크가 어떻게 동작하는지를 검증하기 위한 테스트

### 학습 테스트의 장점
* 다양한 조건에 따른 기능을 손쉽게 확인해 볼 수 있다.
* 학습 테스트 코드를 개발 중에 참고할 수 있다.
* 프레임워크나 제품을 업그레이드할 때 호환성 검증을 보여준다.
* 테스트 작성에 대한 좋은 훈련이 된다.
* 새로운 기술을 공부하는 과정이 즐거워진다.

# 2단계

## 기능 요구 사항
- [x] 디자인 시안을 참고하여 회원가입 뷰를 구현한다.

## 프로그래밍 요구 사항
* [x] ViewModel, Hilt 등은 회원가입 미션에서 활용하지 않는다. 컴포즈 학습에 집중하자.
* [x] 사용자 입력 및 유효성 검사에 대해서는 이 단계에서 고민하지 않아도 된다.
* [x] 컴포저블 함수가 너무 많은 일을 하지 않도록 분리하기 위해 노력해 본다.
* [x] Material3 Button, TextField를 활용한다.

# 3단계

## 기능 요구 사항
- [x] 디자인 시안을 참고하여 회원가입 뷰에 유효성 검사 로직을 추가한다.

## 프로그래밍 요구 사항
- [x] 유효성 검사 로직에 대한 테스트 코드를 추가한다.
