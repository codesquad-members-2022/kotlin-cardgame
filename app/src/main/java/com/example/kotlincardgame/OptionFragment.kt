package com.example.kotlincardgame

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment


class OptionFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_option, container, false)
        val nickname: EditText =
            activity?.findViewById(R.id.edit_text) ?: throw NullPointerException()
        val textView: TextView = view?.findViewById(R.id.user_name) ?: throw NullPointerException()
        val imageView: ImageView =
            view?.findViewById(R.id.user_character) ?: throw NullPointerException()
        val drawable: ImageView =
            activity?.findViewById(R.id.iv_character_info) ?: throw NullPointerException()
        checkUser(nickname, textView, imageView, drawable)
        val button: Button =
            view?.findViewById(R.id.help) ?: throw NullPointerException()
        button.setOnClickListener {
            val urlIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://codesquad.kr/"))
            startActivity(urlIntent)
        }
        return view
    }
}