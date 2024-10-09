```kotlin
@Composable
fun KimposeKKmPose(modifier: Modifier = Modifier.testTag("이름")) {
    Column(
        modifier = modifier
    ) {
        // 바꿔 보세요!
        Text(text = "킴포즈", color = Color.Cyan)
        Text(text = "끔포즈", color = Color.Yellow)
    }
}
```

> Optional Modifier parameter should have a default value of `Modifier`


# Modifier 가 뭔데
An ordered, immutable collection of modifier elements that decorate or add behavior to Compose UI elements. For example, backgrounds, padding and click event listeners decorate or add behavior to rows, text or buttons.
순서가 있는 변경 불가한 modifier 원소 들의 콜렉이다. 
이 원소들은 Compose UI elements 를 꾸며주거나 행동을 추가해준다.
예를 들어 배경, padding, 클릭 이벤트 리스너가 rows, text, 버튼을 꾸며주거나 행동을 추가할 수 있다. 

왜 그렇지?
Modifier는 Composable 함수에서 기본적으로 제공되는 확장 가능하고 체인할 수 있는 객체

Modifier는 기본적으로 빈 객체(Modifier)로 정의하는 것이 관례이며,
특정 값을 기본으로 설정하는 대신 Modifier를 호출 시 덮어쓸 수 있게 제공하는 것이 Compose 스타일 가이드야.

* 빈 Modifier를 기본값으로 해야 하는 이유:
    * 컴포저블 함수가 호출될 때 외부에서 수정 및 확장 가능하게 하기 위해.
* 체이닝을 사용하는 이유:
    * 외부에서 전달된 Modifier를 덮어쓰지 않고, 추가적인 동작을 결합해 유연하게 사용할 수 있도록 하기 위해.





