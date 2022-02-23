package com.codesquad_Han.kotlin_cardgame

import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    var characterNickname : String = ""
    lateinit var characterImageByteArray : ByteArray
}