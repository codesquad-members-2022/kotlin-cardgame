class CardGame(val drawNum:Int, val cardDeck: CardDeck) {

    val userList:Array<User> = Array(3){User(drawNum)}
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

    fun checkWinner():User?{
        val hasMaxScoreUserList = ArrayList<User>()
        val maxScore= getMaxScore()
        userList.map{
            if(it.getCardValueSum()==maxScore){
                hasMaxScoreUserList.add(it)
            }
        }

        return if(hasMaxScoreUserList.size>1){
            null
        } else{
            hasMaxScoreUserList[0]
        }

    }

    fun getWinnerInfo( ):String {
        val winner: User? = this.checkWinner()
        winner?.let {
            return when (this.userList.indexOf(winner)) {
                0 -> "PlayerOne"
                1-> "PlayerTwo"
                2-> "PlayerThree"
                else-> "PlayerRobot"
            }
        }
        return "No Winner"

    }


    fun getMaxScore():Int{
        var max =0
        userList.map{
            if(max<it.getCardValueSum()){
                max= it.getCardValueSum()
            }
        }
        if(max<robot.getCardValueSum()){
            max= robot.getCardValueSum()
        }
        return max
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