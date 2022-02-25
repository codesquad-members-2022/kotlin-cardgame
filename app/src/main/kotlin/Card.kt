/*
카드 클래스가 필요한 것은 과일 그림과 문자열로 변환된 숫자 정보
과일이름(문자열)을 통해 과일을 만드는 기능 과  정수형 value를 숫자에 따라 문자열로 변환하는 기능은 다른 객체에서 수행하고 카드 클래스는 그 객체를 소유함으로 기능을 가져가 쓰기만 하는 구조가
적합하다 생각함

 */

class Card(fruit:FruitShape, cardValue:Int) {
    private val cardValue = CardValue(cardValue)
    private val cardShape = fruit.fruitShape

    fun getValue():Int{
        return this.cardValue.getValue()
    }

    override fun toString(): String {
        return "${this.cardShape} $cardValue"
    }
}

