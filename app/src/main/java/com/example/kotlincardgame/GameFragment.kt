package com.example.kotlincardgame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.forEach
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val nickname: EditText =
            activity?.findViewById(R.id.edit_text) ?: throw NullPointerException()
        val textView: TextView =
            view?.findViewById(R.id.text_nickname) ?: throw NullPointerException()
        val drawable: ImageView =
            activity?.findViewById(R.id.iv_character_info) ?: throw NullPointerException()
        val imageView: ImageView =
            view?.findViewById(R.id.character) ?: throw NullPointerException()
        val button: Button = view?.findViewById(R.id.btn_back)
        val bottomNavigation: BottomNavigationView =
            activity?.findViewById(R.id.bottom_navigation) ?: throw NullPointerException()
        button.text = "이전"
        button.setOnClickListener {
            val fragmentManager = activity?.supportFragmentManager
            fragmentManager?.beginTransaction()?.remove(this)?.commit();
            fragmentManager?.popBackStack();
            bottomNavigation.menu.forEach { it.isEnabled = false }
        }
        checkUser(nickname, textView, imageView, drawable)
    }

}