
interface IDeck {
    fun count(): Int
    fun shuffle()
    fun removeOne(): ICard?
    fun reset()
}
