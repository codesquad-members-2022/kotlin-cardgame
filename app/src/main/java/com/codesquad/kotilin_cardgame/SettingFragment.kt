package com.codesquad.kotilin_cardgame


import android.content.Intent
import android.graphics.BitmapFactory
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
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val nickNameView = view.findViewById<TextView>(R.id.tv_nickname_card)
        val profileImageView = view.findViewById<ImageView>(R.id.iv_profile_frame_card)
        val helpButton = view.findViewById<Button>(R.id.btn_help_frame)
        val nickname = arguments?.getString("nickname")
        val byteArray = arguments?.getByteArray("image")
        val bitmap = byteArray?.let {
            BitmapFactory.decodeByteArray(byteArray, 0, it.size)
        }
        nickNameView.text=nickname
        profileImageView.setImageBitmap(bitmap)
        helpButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://codesquad.kr/"))
            startActivity(intent)
        }


    }
}