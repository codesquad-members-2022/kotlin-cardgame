package com.example.kotlin_cardgame

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


class SettingFragment : Fragment() {
    lateinit var nicknameTextView: TextView
    lateinit var emotionImageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_seting, container, false)
        nicknameTextView = view.findViewById(R.id.nickname_text_view)
        emotionImageView = view.findViewById(R.id.emotion_image_view)

        initiate(container)

        return view
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