package com.example.kotlincardgame

import android.graphics.Color
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

fun checkUser(
    nickname: EditText,
    textView: TextView,
    imageView: ImageView,
    drawable: ImageView
) = when (nickname.text.toString()) {
        "" -> guestUser(textView, imageView)
        else -> memberUser(nickname, textView, imageView, drawable)
    }

private fun guestUser(textView: TextView, imageView: ImageView) {
    textView.text = "Guest"
    imageView.setBackgroundColor(Color.GRAY)
}

private fun memberUser(
    nickname: EditText,
    textView: TextView,
    imageView: ImageView,
    drawable: ImageView
) {
    textView.text = nickname.text
    imageView.setImageDrawable(drawable.drawable)
}