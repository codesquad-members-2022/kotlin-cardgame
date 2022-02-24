package com.example.kotlin_cardgame

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

private const val HELP_URL = "https://codesquad.kr/"

class SettingFragment : Fragment() {
    private lateinit var nicknameTextView: TextView
    private lateinit var emotionImageView: ImageView
    lateinit var informationButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_seting, container, false)
        nicknameTextView = view.findViewById(R.id.nickname_text_view)
        emotionImageView = view.findViewById(R.id.emotion_image_view)
        informationButton = view.findViewById(R.i   d.information_button)

        initiate(container)
        informationButtonListening()

        return view
    }

    private fun informationButtonListening() {
        informationButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(HELP_URL))
            startActivity(intent)
        }
    }

    private fun initiate(container: ViewGroup?) {
        val nickname = arguments?.getString("nickname")
        val emotionEnum: EmotionEnum = arguments?.getSerializable("emotion") as EmotionEnum

        emotionImageView.setImageBitmap(container?.context?.let {
            Emotion.getImage(
                it,
                emotionEnum
            )
        })
        nicknameTextView.text = nickname
    }
}