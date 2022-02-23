package com.codesquad.kotlincardgame.ui

object InputView {

    private const val PROMPT = "> "

    fun execute(): String? {
        print(PROMPT)
        return readLine()
    }
}