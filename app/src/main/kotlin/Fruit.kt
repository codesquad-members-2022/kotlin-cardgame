/*
미션에서 과일 타입에 대해 변화를 주는 요구사항은 없었지만
만약 과일의 모양을 바꾸거나, 이름을 바꿔야 할때 정적으로 변환가능한 Sealed class를 사용했다.
 */

sealed class Fruit {
   data class Apple(val fruitName: String = "Apple", val fruitShape: String = "\uD83C\uDF4E") : Fruit()
   data class Grape(val fruitName: String = "Grape", val fruitShape: String = "\uD83C\uDF47") : Fruit()
   data class Cherry(val fruitName: String = "Cherry", val fruitShape: String = "\uD83C\uDF52") : Fruit()
   data class Orange(val fruitName: String = "Orange", val fruitShape: String = "\uD83C\uDF4A") : Fruit()
}
