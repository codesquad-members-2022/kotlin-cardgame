
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