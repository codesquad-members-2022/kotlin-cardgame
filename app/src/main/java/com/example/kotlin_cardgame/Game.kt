import com.example.kotlin_cardgame.GameModeEnum

class Game(val gameMode: GameModeEnum, val cardDeck: IDeck, private val users: List<User>? = null) {

    private var userList = users ?: getUserList()
    private var robotCardList = mutableListOf<ICard>()
    private val robotCardVolume: Int = 3

    init {
        cardDeck.shuffle()
        distributeCard()
    }

    private fun endGame() {
        // 게임을 끝내는 코드
    }

    private fun distributeCard() {
        // 컴퓨터(로봇)의 카드 체우기
        while (robotCardList.size < robotCardVolume) {
            cardDeck.removeOne()?.let { it1 -> robotCardList.add(it1) } ?: endGame()
        }
        // 플레이어 카드 배분
        userList?.forEach { user ->
            val gameModeInt = getGameModeInt()
            repeat(gameModeInt) {
                cardDeck.removeOne()?.let { it1 -> user.addCardList(it1) } ?: endGame()
            }
        }
    }

    private fun getGameModeInt(): Int {
        return when (gameMode) {
            GameModeEnum.DOUBLE -> 2
            GameModeEnum.TRIPLE -> 3
            GameModeEnum.QUADRUPLE -> 4
        }
    }

    fun getUserCardState(): String {
        val usersState = StringBuilder()
        userList.forEach {
            usersState.append(it.getCardState())
            usersState.append("\n")
        }

        usersState.append("computer //")
        robotCardList.forEach { usersState.append(" $it ") }
        return usersState.toString()
    }

    private fun getUserList(): List<User> {
        return listOf<User>(User(null), User(null), User(null))
    }


}