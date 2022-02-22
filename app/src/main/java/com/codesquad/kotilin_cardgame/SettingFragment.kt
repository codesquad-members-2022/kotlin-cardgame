package com.codesquad.kotilin_cardgame

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.Color.*
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class SettingFragment : Fragment() {
    lateinit var nickname:String
    lateinit var profileImage:Bitmap
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_setting, container, false)
        val nickNameView= view.findViewById<TextView>(R.id.tv_nickname_card)
        val profileImageView= view.findViewById<ImageView>(R.id.iv_profile_frame_card)
        val helpButton = view.findViewById<Button>(R.id.btn_help_frame)
        helpButton.setOnClickListener {
            val intent= Intent(Intent.ACTION_VIEW, Uri.parse("https://codesquad.kr/"))
            startActivity(intent)
        }
        nickNameView.setText(this.nickname)
        profileImageView.setImageBitmap(profileImage)
        return view
    }

    fun setNickName(nickname: String){
        this.nickname=nickname
    }

    fun setImage(image:Bitmap){
        this.profileImage= image
    }
}