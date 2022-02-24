
class CardShape(fruitName:String) {
    val fruitShape: String = when(fruitName){
        "Apple","apple"-> {
            Fruit.Apple().fruitShape
        }
        "Grape","grape"->{
            Fruit.Grape().fruitShape
        }
        "Cherry","cherry"->{
            Fruit.Cherry().fruitShape
        }
        "Orange","orange"->{
            Fruit.Orange().fruitShape
        }
        else-> ""
    }

    override fun toString(): String {
        return "$fruitShape"
    }

}