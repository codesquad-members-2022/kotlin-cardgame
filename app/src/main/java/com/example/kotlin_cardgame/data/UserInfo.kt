package com.example.kotlin_cardgame.data

import java.io.Serializable

data class UserInfo(
    val byteArrayOfImage: ByteArray,
    val nickname: String
) : Serializable
