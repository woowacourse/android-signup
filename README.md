# android-signup# android-signup

# Step1

## 기능 요구 사항
아래에 제시된 학습 테스트를 완성한다.

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
