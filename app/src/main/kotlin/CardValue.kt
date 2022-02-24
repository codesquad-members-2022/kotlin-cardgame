/*
String을 통해 enum 클래스로 처리할수도 있다고 생각햇지만,
ONE("A) ,TWO("2") ..
2-8까지는 숫자를 문자열로 변환하는거 때문에 enum으로 처리할 이유가 없다고 생각함
게다가 카드에 담아야 하는 숫자의 범위가 커지게 될 경우 enum으로 처리하는데 한계가 있다고 생각함
 */
class CardValue(intValue:Int){
    private val stringValue:String = when(intValue){
        1-> "A"
        10->"X"
        else-> intValue.toString()
    }

    override fun toString(): String {
        return "$stringValue"
    }

}
