fun main(){
    val cardDeck= CardDeck(40)
    val CardGame = CardGame(3, cardDeck )
    CardGame.giveOutCard()
    println(CardGame.userList[0].userDeck)

}