package com.example.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class SettingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gameID = view?.findViewById<TextView>(R.id.show_id_text)
        val characterImage = view?.findViewById<ImageView>(R.id.character_selected_image)
        val userData = arguments?.getSerializable("user") as User

        gameID?.text = userData.username
        characterImage?.setImageResource(userData.Image)
    }
}