package com.codesquad.kotilin_cardgame

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.Color.*
import android.os.Bundle
import android.provider.ContactsContract
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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