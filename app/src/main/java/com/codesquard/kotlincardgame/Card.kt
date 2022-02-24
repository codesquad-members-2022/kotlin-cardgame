package com.codesquard.kotlincardgame

fun main() {
    val a: Card = AppleCard(1)
    val b: Card = OrangeCard(2)
    val c: Card = CherryCard(9)
    val d: Card = GrapeCard(10)
    val e: Card = GrapeCard(11)
    a.printCardInfo()
    b.printCardInfo()
    c.printCardInfo()
    d.printCardInfo()
    e.printCardInfo()
}

/*
숫자의 데이터 구조 : 싱글턴을 활용하여 Array<String>를 사용함
1. 싱글턴을 사용한 이유
    - 각 타입별로 총 4개의 카드 객체를 생성하고 각 카드의 숫자는 싱글턴 객체의 배열에서 인덱스를 통해 할당하려고 했음. 이에 객체는 1번만 생성하면 되기 때문에 싱글톤을 활용함
2. Array를 사용한 이유
    - 미리 사이즈가 정해져 있기 때문에, 이후에 요소를 추가하거나 제거할 수 없도록 하기 위해
        - 만약 이후에 카드 숫자가 늘어나거나 줄어드는 등 동적으로 변화되지 않고 (add나 remove 등 메서드를 쓸 수 없으니) 컴파일 때 정해지도록 arrayOf("A", "2", "3", "4", "5", "6", "7", "8", "9", "X", "추가", 추가")처럼 직접 요소를 추가하도록 하기 위해
    - 배열을 통해 사용자가 사이즈에 벗어난 값을 카드 번호로 넣으면 "0"을 할당해 이후에 예외 처리를 쉽게 하기 위해
3. 문자열을 사용한 이유
    - 나중에 문자열로 출력할 때 편하기 위해
    - 문자인 A와 X를 출력해야 하기 때문에
*/
object CardNumber {
    val numberArray: Array<String> = arrayOf("A", "2", "3", "4", "5", "6", "7", "8", "9", "X")
}

/*
모양의 데이터 구조 : 인터페이스를 상속받은 클래스
1. 모양을 클래스로 나눈 이유
    - 각각의 모양은 클래스의 이름을 통해 알 수 있도록 구현했으며 각 클래스별로 이름과 동일한 유니코드 이미지를 프로퍼티로 가지도록 함.
    - 이후에 추가 요구 사항으로 다른 모양의 카드가 추가되더라도 Card를 상속받은 클래스만 추가하면 다른 클래스 및 코드를 수정할 필요없도록 하기 위해. (추상타입활용)
2. 인터페이스를 사용한 이유
    - 프로퍼티 중 image만 모양에 따라 달라지면 되고, 나머지 속성인 number(카드숫자)는 동일하기 때문에 재사용성을 위해 상속을 활용함
    - 커스텀 접근자를 통해 카드 숫자는 입력된 inputNumber에 따라 생성할 때마다 다르게 할당되도록 함
3. Image가 String 타입인 이유
    - 유니코드의 자바코드를 활용했고 이 자바코드가 String 타입이기 때문에
 */
interface Card {
    val inputNumber: Int
    val image: String
    val number: String
        get() {
            return if (inputNumber <= CardNumber.numberArray.size)
                CardNumber.numberArray[inputNumber - 1]
            else "0"
        }

    fun printCardInfo() {
        println(image + number)
    }
}

class AppleCard(override val inputNumber: Int) : Card {
    override val image = "\uD83C\uDF4E"
}

class OrangeCard(override val inputNumber: Int) : Card {
    override val image = "\uD83C\uDF4A"
}

class CherryCard(override val inputNumber: Int) : Card {
    override val image = "\uD83C\uDF52"
}

class GrapeCard(override val inputNumber: Int) : Card {
    override val image = "\uD83C\uDF47"
}



