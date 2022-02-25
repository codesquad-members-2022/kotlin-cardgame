class FruitCard(private val fruitEnum: FruitEnum, private val num: Int) : ICard {

    override fun toString(): String {
        val nuwNum = if (num == 10) 'X' else if (num == 1) 'A' else num
        return getFruitEmoji(fruitEnum) + nuwNum
    }

    private fun getFruitEmoji(fruitEnum: FruitEnum): String {
        return when (fruitEnum) {
            FruitEnum.APPLE -> "\uD83C\uDF4E"
            FruitEnum.ORANGE -> "\uD83C\uDF4A"
            FruitEnum.CHERRY -> "\uD83C\uDF52"
            FruitEnum.GRAPE -> "\uD83C\uDF47"
        }
    }
}

enum class FruitEnum {
    APPLE, ORANGE, CHERRY, GRAPE
}