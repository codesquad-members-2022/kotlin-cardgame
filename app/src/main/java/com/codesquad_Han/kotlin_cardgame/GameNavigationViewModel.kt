package com.codesquad_Han.kotlin_cardgame

import androidx.lifecycle.ViewModel

class GameNavigationViewModel : ViewModel() {
    lateinit var characterNickname: String
    lateinit var characterImageByteArray: ByteArray
}