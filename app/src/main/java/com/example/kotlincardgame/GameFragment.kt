package com.example.kotlincardgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.kotlincardgame.databinding.ActivityMainBinding
import java.lang.NullPointerException

class GameFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_game, container, false)
        val textView: TextView = view?.findViewById(R.id.text_nickname) ?: throw NullPointerException()
        val nickname: EditText = activity?.findViewById(R.id.edit_text) ?: throw NullPointerException()
        textView.text = nickname.text
        val drawable: ImageView = activity?.findViewById(R.id.iv_character_info) ?: throw NullPointerException()
        val imageView: ImageView = view?.findViewById(R.id.character) ?: throw NullPointerException()
        imageView.setImageDrawable(drawable.drawable)
        return view
    }

}