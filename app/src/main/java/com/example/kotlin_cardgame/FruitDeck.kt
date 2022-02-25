import java.util.*

class FruitDeck() : IDeck {

    companion object {
        private val composition1 =
            listOf<FruitEnum>(FruitEnum.ORANGE, FruitEnum.GRAPE, FruitEnum.CHERRY, FruitEnum.APPLE)
        private val composition2 = (1..10).toList()
    }

    private var cardStack = Stack<FruitCard>()

    init {
        reset()
    }

    override fun count(): Int {
        return cardStack.size
    }

    override fun shuffle() {
        val cardList = cardStack.toMutableList()
        val newStack = Stack<FruitCard>()
        while (cardList.size != 0) {
            val size = cardList.size
            val randomIndex = Random().nextInt(size)
            newStack.push(cardList[randomIndex])
            cardList.removeAt(randomIndex)
        }
        cardStack = newStack
    }

    override fun removeOne(): ICard? {
        return if (cardStack.size == 0) null
        else cardStack.pop()
    }

    override fun reset() {
        // var 로하고 다시 할당한다
        cardStack = Stack<FruitCard>()
        for (i in composition1.indices) {
            for (j in composition2.indices) {
                cardStack.push(FruitCard(composition1[i], composition2[j]))
            }
        }
    }
}