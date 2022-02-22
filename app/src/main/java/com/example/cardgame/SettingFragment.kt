package com.example.cardgame

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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
        val actionBar = (activity as SecondActivity).supportActionBar
        actionBar?.title = "설정"

        val nickName = view.findViewById<TextView>(R.id.textView)
        val imageView = view.findViewById<ImageView>(R.id.imageView)
        val button = view.findViewById<Button>(R.id.btnHelp)

        val nickname = arguments?.getString("nickname")
        val characterChosen = arguments?.getInt("character")

        when (characterChosen){
            1->imageView.setImageResource(R.drawable.ic_baseline_emoji_emotions_24)
            2->imageView.setImageResource(R.drawable.ic_baseline_face_24)
            3->imageView.setImageResource(R.drawable.ic_baseline_mood_bad_24)
            else -> imageView.setImageResource(R.drawable.ic_baseline_sentiment_dissatisfied_24)
        }

        nickName.setText(nickname)
        button.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://codesquad.kr/")))
        }
    }
}