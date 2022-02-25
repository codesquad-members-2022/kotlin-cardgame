package com.codesquad.kotlincardgame.ui

object InputView {

    private const val PROMPT = "> "
    private const val QUESTION_MODE = "게임 모드를 선택하세요(2카드, 3카드, 4카드)"

    fun askGameModeSelection() = println(QUESTION_MODE)

    fun execute(): String? {
        print(PROMPT)
        return readLine()
    }
}