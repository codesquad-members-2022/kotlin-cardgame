class CardDeckView {
    companion object {
        fun startCardDeckViewer() {
            print("Please Input Card Deck Size: ")
            val deckSize = readLine()?.toInt()
            val cardDeck = deckSize?.let { CardDeck(it) }
            println("CardDeck is initialized")
            println(cardDeck)
            println()
            while(true) {
                print("Please Input Command: ")
                var cmd = readLine()
                when (cmd) {
                    "Shuffle" -> {
                        cardDeck?.shuffle()
                        println("Shuffle ${cardDeck?.count()} Card ")
                    }
                    "Draw" -> {
                        println(cardDeck?.removeOne())
                    }
                    "Reset" -> {
                        cardDeck?.resetDeck()
                    }
                    "Count" -> {
                        println(cardDeck?.count())
                    }
                    "Exit","exit"->{
                        break
                    }
                }
                println(cardDeck)
                println()
            }
        }
    }
}

