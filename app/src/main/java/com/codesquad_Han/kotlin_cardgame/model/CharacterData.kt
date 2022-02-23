package com.codesquad_Han.kotlin_cardgame.model

import android.graphics.drawable.Drawable
import java.io.Serializable

data class CharacterData(
    val nickName : String,
    val byteArray : ByteArray
) : Serializable