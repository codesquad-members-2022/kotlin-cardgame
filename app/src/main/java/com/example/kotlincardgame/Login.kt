package com.example.kotlincardgame

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.view.View
import androidx.preference.PreferenceManager
import android.widget.ImageView
import android.widget.TextView

fun checkUser(
    view: View,
    nickname: String?,
    textView: TextView,
    imageView: ImageView,
    resName: String?,
    packName: String
) = when (nickname) {
    null -> getGuestUserPage(textView, imageView)
    else -> getMemberUserPage(view, nickname, textView, imageView, resName, packName)
}

private fun getGuestUserPage(textView: TextView, imageView: ImageView) {
    textView.text = "Guest"
    imageView.setBackgroundColor(Color.GRAY)
}

private fun getMemberUserPage(
    view: View,
    nickname: String?,
    textView: TextView,
    imageView: ImageView,
    resName: String?,
    packName: String
) {
    textView.text = nickname
    val resID: Int = view.resources.getIdentifier(resName, "drawable", packName)
    imageView.setImageResource(resID)
}

class Login {
    fun setAttribute(context: Context, key: String, value: String) {
        val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor: SharedPreferences.Editor = prefs.edit()
        editor.putString(key, value)
        editor.commit()
    }

    fun getAttribute(context: Context, key: String): String? {
        val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getString(key, null)
    }

    fun removeAttribute(context: Context, key: String) {
        val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor: SharedPreferences.Editor = prefs.edit()
        editor.remove(key)
        editor.commit()
    }

    fun removeAllAttribute(context: Context) {
        val prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor: SharedPreferences.Editor = prefs.edit()
        editor.clear()
        editor.commit()
    }

}