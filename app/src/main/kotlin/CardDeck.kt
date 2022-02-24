import java.util.*

class CardDeck(deckSize: Int) {
    val cardDeck: ArrayList<Card> = arrayListOf()
    private val removedDeck: ArrayList<Pair<Int, Card>> = arrayListOf()
    private val fruitList = listOf<String>("Apple", "Grape", "Cherry", "Orange")

    init {
        makeDeck(deckSize)
    }

    fun count(): Int {
        return cardDeck.size
    }

    fun shuffle() {
        val random = Random()
        for (i in 0 until cardDeck.size) {
            val randomPos = random.nextInt(i + 1)
            val temp = cardDeck[randomPos]
            cardDeck[randomPos] = cardDeck[i]
            cardDeck[i] = temp
        }
    }

    fun resetDeck() {
        if (removedDeck.isNotEmpty()) {
            removedDeck.map {
                cardDeck.add(it.first, it.second)
            }
        }
    }

    fun removeOne(): Card {
        val randomCardNum = (0 until count()).random()
        val removedCard = cardDeck[randomCardNum]
        cardDeck.removeAt(randomCardNum)
        removedDeck.add(Pair(randomCardNum, removedCard))
        return removedCard
    }

    private fun makeDeck(deckSize: Int) {
        for (i in 0 until deckSize) {
            cardDeck.add(makeRandomCard())
        }
    }

    private fun makeRandomCard(): Card {
        val fruitRandom = fruitList[(0..3).random()]
        val cardValue = (1..10).random()
        return Card(fruitRandom, cardValue)
    }

    override fun toString(): String {
        var deckInfo :String =" "
        deckInfo += cardDeck.map{ "$it " }
        return deckInfo
    }


}