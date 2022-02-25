
class User(cardNum:Int) {
    var userName:String = randomUsrName()
    val userDeck:CardDeck = CardDeck(cardNum)

    private fun randomUsrName():String{
        val leftLimit= 97
        val rightLimit= 122
        val targetLength= (3..5).random()
        return getRandomString(targetLength)
    }

    private fun getRandomString(length: Int) : String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }

    fun getCardValueSum():Int{
        var sum=0
        userDeck.cardDeck.map{
            sum+= it.getValue()
        }
        return sum
    }
}

