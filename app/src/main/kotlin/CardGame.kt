class CardGame(val drawNum:Int, val cardDeck: CardDeck) {

    val userList:Array<User> = Array(3){User(0)}
    val robot = User(3)
    init {
        while(!checkUserName(userList)) {
            for (i in 0 until 3) {
                userList[i] = User(drawNum)
            }
        }
    }

    fun giveOutCard():Int{
        userList.map{
            for(i in 0 until drawNum){
                it.userDeck.cardDeck[i]= cardDeck.removeOne()
            }
        }
        for(i in 0 until 3){
            robot.userDeck.cardDeck[i]= cardDeck.removeOne()
        }
        return cardDeck.count()
    }

    fun checkUserGetDrawCard():Boolean{
        return userList.all{it.userDeck.count()==drawNum}
    }

    companion object {
        fun checkUserName(userList: Array<User>):Boolean{
            return checkOnlyAlphabet(userList)&& checkDuplicate(userList)&& checkUserNameLength(userList)
        }


        fun checkOnlyAlphabet(userList: Array<User>): Boolean {
            val pattern = Regex("^[a-zA-Z]*\$")
            return userList.all { pattern.matches(it.userName) }
        }

        fun checkUserNameLength(userList: Array<User>): Boolean {
            return userList.all { it.userName.length in 2..5 }
        }

        fun checkDuplicate(userList: Array<User>): Boolean {
            return (userList.distinct().size ==3)

        }


    }
}