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
    "" -> getGuestUserPage(textView, imageView)
    else -> getMemberUserPage(nickname, textView, imageView, drawable)
}

private fun getGuestUserPage(textView: TextView, imageView: ImageView) {
    textView.text = "Guest"
    imageView.setBackgroundColor(Color.GRAY)
}

private fun getMemberUserPage(
    nickname: EditText,
    textView: TextView,
    imageView: ImageView,
    drawable: ImageView
) {
    textView.text = nickname.text
    imageView.setImageDrawable(drawable.drawable)
}