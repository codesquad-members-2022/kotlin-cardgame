/*
카드가 필요로 하는건 과일 이름에 따른 과일 모양 유니코드 정보다
처음 설계시  String으로 과일 이름을 받고,  When문을 통해 과일을 리턴하는 식으로 햇는데
추후 요구사항을 봐도 카드 클래스가 과일 객체를 가지고 있을 필요는 없어보여서, enum으로 처리해 과일 모양값만 전달하는 식으로 수정했다.
 */

enum class FruitShape(val fruitShape: String){
    APPLE( "\uD83C\uDF4E"),
    GRAPE("\uD83C\uDF47"),
    CHERRY("\uD83C\uDF52"),
    ORANGE("\uD83C\uDF4A")
}
